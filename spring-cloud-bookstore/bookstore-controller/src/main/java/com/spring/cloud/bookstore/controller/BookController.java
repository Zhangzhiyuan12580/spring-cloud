package com.spring.cloud.bookstore.controller;

import com.github.pagehelper.PageInfo;
import com.spring.cloud.bookstore.service.IBookService;
import com.spring.cloud.core.bookstore.BookDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "书籍分页接口", notes = "书籍分页接口", httpMethod = "GET", tags = "用户相关Api")
    @GetMapping(value = "pageList")
    public PageInfo<BookDTO> pageList(@ApiParam(value = "名称") @RequestParam(required = false) String name,
                                      @ApiParam(value = "第几页，从0开始") @RequestParam(required = false, defaultValue = "0") Integer page,
                                      @ApiParam(value = "每页多少个") @RequestParam(required = false, defaultValue = "10") Integer size) {
        BookDTO dto = new BookDTO();
        if (StringUtils.isNotEmpty(name)) {
            dto.setName(name.trim());
        }
        return bookService.findPage(dto, page, size);
    }
}
