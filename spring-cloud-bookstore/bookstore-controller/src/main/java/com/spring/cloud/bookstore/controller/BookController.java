package com.spring.cloud.bookstore.controller;

import com.github.pagehelper.PageInfo;
import com.spring.cloud.bookstore.domain.Book;
import com.spring.cloud.bookstore.dto.BookDTO;
import com.spring.cloud.bookstore.service.BookService;
import com.spring.cloud.core.response.RestResponse;
import com.spring.cloud.core.util.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "书籍相关Api")
@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @ApiOperation(value = "根据ID获取书籍", notes = "根据ID获取书籍", tags = "书籍相关Api")
    @GetMapping("findById")
    public RestResponse<BookDTO> findById(@ApiParam(value = "书籍ID", required = true) @RequestParam Long id) {
        return RestResponse.ok(bookService.findOne(id));
    }

    @ApiOperation(value = "书籍分页接口", notes = "书籍分页接口", tags = "用户相关Api")
    @GetMapping("pageList")
    public RestResponse<PageInfo<BookDTO>> pageList(@ApiParam("名称") String name,
                                                    @ApiParam("第几页，从0开始") @RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @ApiParam("每页多少个") @RequestParam(required = false, defaultValue = "10") Integer size) {
        PageInfo<Book> pageInfo = bookService.findPage(StringUtils.trimToEmpty(name), page, size);
        PageInfo<BookDTO> dtoPageInfo = PageUtils.transfer(pageInfo, book -> {
            BookDTO bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            return bookDTO;
        });
        return RestResponse.ok(dtoPageInfo);
    }
}
