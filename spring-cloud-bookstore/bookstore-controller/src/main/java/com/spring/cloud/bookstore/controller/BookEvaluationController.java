package com.spring.cloud.bookstore.controller;

import com.spring.cloud.bookstore.dto.BookEvaluationDTO;
import com.spring.cloud.bookstore.service.BookEvaluationService;
import com.spring.cloud.core.response.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(description = "书籍评论Api")
@RestController
@RequestMapping("/bookEvaluation")
@AllArgsConstructor
public class BookEvaluationController {

    private final BookEvaluationService bookEvaluationService;

    @ApiOperation(value = "书籍评论保存接口", notes = "书籍评论保存接口", tags = "书籍评论Api")
    @PostMapping("save")
    public RestResponse save(@RequestBody @Validated(BookEvaluationDTO.SaveGroup.class) BookEvaluationDTO dto) {
        bookEvaluationService.save(dto);
        return RestResponse.OK;
    }

    @ApiOperation(value = "书籍评论修改接口", notes = "书籍评论修改接口", tags = "书籍评论Api")
    @PostMapping("update")
    public RestResponse update(@RequestBody @Validated(BookEvaluationDTO.UpdateGroup.class) BookEvaluationDTO dto) {
        bookEvaluationService.update(dto);
        return RestResponse.OK;
    }

    @ApiOperation(value = "书籍评论查看接口", notes = "书籍评论查看接口", tags = "书籍评论Api")
    @GetMapping("findById")
    public RestResponse<BookEvaluationDTO> findById(@ApiParam(value = "书籍评论ID", required = true) @RequestParam Long id) {
        BookEvaluationDTO bookEvaluationDTO = bookEvaluationService.findById(id);
        return RestResponse.ok(bookEvaluationDTO);
    }

    @ApiOperation("书籍评论删除接口")
    @DeleteMapping
    public RestResponse delete(@RequestParam Long id) {
        bookEvaluationService.removeById(id);
        return RestResponse.OK;
    }

}
