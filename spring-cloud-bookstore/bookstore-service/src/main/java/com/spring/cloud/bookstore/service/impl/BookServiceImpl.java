package com.spring.cloud.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.cloud.basic.feign.IBasicFeign;
import com.spring.cloud.bookstore.domain.Book;
import com.spring.cloud.bookstore.mapper.BookMapper;
import com.spring.cloud.bookstore.service.IBookService;
import com.spring.cloud.core.basic.UserInfoDTO;
import com.spring.cloud.core.bookstore.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zzy
 * @Date 2019-03-24-10:37
 * @Description
 **/
@Slf4j
@Service(value = "bookService")
public class BookServiceImpl implements IBookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private IBasicFeign basicFeign;

    @Override
    public BookDTO findOne(Long id) {
        Assert.notNull(id, "查询数据ID不能为空！");
        Book book = bookMapper.findOne(id);
        Assert.notNull(book, "没有ID为" + id + "的book");
        BookDTO dto = new BookDTO();
        BeanUtils.copyProperties(book, dto);
        model2Dto(dto);
        return dto;
    }

    @Override
    public PageInfo<BookDTO> findPage(BookDTO bookDTO, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<BookDTO> list = bookMapper.findPage(bookDTO);
        return new PageInfo<BookDTO>(list);
    }

    private void model2Dto(BookDTO dto) {
        if (StringUtils.isNotEmpty(dto.getAuthorId())) {
            UserInfoDTO user = basicFeign.findById(Long.valueOf(dto.getAuthorId()));
            if (null != user) {
                dto.setAuthorName(user.getUserName());
            }
        }
    }
}
