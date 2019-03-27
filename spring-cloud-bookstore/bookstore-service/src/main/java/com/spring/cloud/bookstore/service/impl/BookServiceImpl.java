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
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    private final BasicFeign basicFeign;

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

    private void model2Dto(BookDTO dto) {
        if (dto.getAuthorId() != null) {
            UserInfoDTO user = basicFeign.findById(dto.getAuthorId());
            if (null != user) {
                dto.setAuthorName(user.getUserName());
            }
        }
    }
}
