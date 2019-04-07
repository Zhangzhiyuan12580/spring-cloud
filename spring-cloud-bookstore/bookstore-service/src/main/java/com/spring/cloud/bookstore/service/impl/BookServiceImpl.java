package com.spring.cloud.bookstore.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.cloud.basic.dto.UserInfoDTO;
import com.spring.cloud.basic.feign.BasicFeign;
import com.spring.cloud.bookstore.domain.Book;
import com.spring.cloud.bookstore.dto.BookDTO;
import com.spring.cloud.bookstore.mapper.BookMapper;
import com.spring.cloud.bookstore.service.BookService;
import com.spring.cloud.bookstore.service.UserRedisOperate;
import com.spring.cloud.core.response.RestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    private final BasicFeign basicFeign;

    @Autowired
    private UserRedisOperate userRedisOperate;

    @Override
    public BookDTO findOne(Long id) {
        Book book = baseMapper.selectById(id);
        Assert.notNull(book, "没有ID为" + id + "的book");
        BookDTO dto = new BookDTO();
        BeanUtils.copyProperties(book, dto);
        model2Dto(dto);
        return dto;
    }

    @Override
    public PageInfo<Book> findPage(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> list = baseMapper.selectList(Wrappers.<Book>lambdaQuery().like(StringUtils.isNotEmpty(name), Book::getName, name));
        return new PageInfo<>(list);
    }

    /**
     * 改造为先从redis中获取
     *
     * @param dto
     */
    private void model2Dto(BookDTO dto) {
        if (dto.getAuthorId() != null) {
            UserInfoDTO redisUser = userRedisOperate.findOne(dto.getAuthorId());
            if (null != redisUser) {
                log.info("从redis中获取到用户：{}的信息", dto.getAuthorId());
                dto.setAuthorName(redisUser.getUserName());
            } else {
                //从远程加载
                RestResponse<UserInfoDTO> user = basicFeign.findById(dto.getAuthorId());
                if (null != user && user.getCode() == 200 && null != user.getData()) {
                    dto.setAuthorName(user.getData().getUserName());
                    //缓存进redis
                    userRedisOperate.saveUser(user.getData());
                }
            }
        }
    }

}
