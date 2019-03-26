package com.spring.cloud.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.spring.cloud.core.bookstore.BookDTO;

/**
 * @Author zzy
 * @Date 2019-03-24-10:36
 * @Description
 **/
public interface IBookService {
    BookDTO findOne(Long id);

    PageInfo<BookDTO> findPage(BookDTO bookDTO, int pageNo, int pageSize);
}
