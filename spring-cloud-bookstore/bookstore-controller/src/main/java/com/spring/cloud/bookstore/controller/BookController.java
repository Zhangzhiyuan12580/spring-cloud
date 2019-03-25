package com.spring.cloud.bookstore.controller;

import com.spring.cloud.bookstore.service.IBookService;
import com.spring.cloud.core.bookstore.BookDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zzy
 * @Date 2019-03-24-10:46
 * @Description
 **/
@Slf4j
@Api(value = "BookController", description = "书籍相关Api")
@RestController
@RequestMapping(value = "/books", method = {RequestMethod.GET, RequestMethod.POST})
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation(value = "根据ID获取书籍", notes = "根据ID获取书籍", httpMethod = "GET", tags = "书籍相关Api")
    @GetMapping(value = "findById")
    public BookDTO findById(@ApiParam(value = "书籍ID", required = true) Long id) {
        return bookService.findOne(id);
    }

}
