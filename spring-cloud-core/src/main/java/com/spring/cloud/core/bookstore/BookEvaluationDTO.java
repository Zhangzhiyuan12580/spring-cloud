package com.spring.cloud.core.bookstore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: BookEvaluationDTO
 * @Author: zzy
 * @Date: 2019/3/25 14:52
 * @Version: 1.2
 * @Description:
 */
@EqualsAndHashCode
@Data
@ApiModel(value = "BookEvaluationDTO", description = "书籍评论信息DTO")
public class BookEvaluationDTO {

    @ApiModelProperty("数据ID")
    private Long id;

    @ApiModelProperty("评论者ID")
    private String commentatorId;

    @ApiModelProperty("书籍ID")
    private String bookId;

    @ApiModelProperty("评论信息")
    private String evaluationInfo;

}
