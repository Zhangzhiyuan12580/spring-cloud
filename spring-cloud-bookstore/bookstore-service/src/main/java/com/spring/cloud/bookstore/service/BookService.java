package com.spring.cloud.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.spring.cloud.bookstore.domain.Book;
import com.spring.cloud.bookstore.dto.BookDTO;

public interface BookService extends IService<Book> {
    BookDTO findOne(Long id);

    PageInfo<Book> findPage(String name, int pageNum, int pageSize);
}
