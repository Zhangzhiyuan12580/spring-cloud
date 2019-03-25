package com.spring.cloud.bookstore.controller;

import com.spring.cloud.bookstore.service.IBookEvaluationService;
import com.spring.cloud.core.bookstore.BookEvaluationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: BookEvaluationController
 * @Author: zzy
 * @Date: 2019/3/25 15:04
 * @Version: 1.2
 * @Description:
 */

@Slf4j
@Api(value = "BookEvaluationController", description = "书籍评论Api")
@RestController
@RequestMapping(value = "/bookEvaluation", method = {RequestMethod.GET, RequestMethod.POST})
public class BookEvaluationController {

    @Autowired
    private IBookEvaluationService bookEvaluationService;

    @ApiOperation(value = "书籍评论保存接口", notes = "书籍评论保存接口", httpMethod = "POST", tags = "书籍评论Api")
    @PostMapping(value = "save")
    public void save(@ApiParam(value = "书籍评论信息", required = true) @RequestBody BookEvaluationDTO dto) {
        bookEvaluationService.save(dto);

    }

    @ApiOperation(value = "书籍评论修改接口", notes = "书籍评论修改接口", httpMethod = "POST", tags = "书籍评论Api")
    @PostMapping(value = "update")
    public void update(@ApiParam(value = "书籍评论信息", required = true) @RequestBody BookEvaluationDTO dto) {
        bookEvaluationService.update(dto);

    }

    @ApiOperation(value = "书籍评论查看接口", notes = "书籍评论查看接口", httpMethod = "GET", tags = "书籍评论Api")
    @GetMapping(value = "findById")
    public BookEvaluationDTO findById(@ApiParam(value = "书籍评论ID", required = true) Long id) {
        return bookEvaluationService.findById(id);
    }

}
