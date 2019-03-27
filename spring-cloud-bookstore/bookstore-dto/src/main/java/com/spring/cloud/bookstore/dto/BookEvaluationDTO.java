package com.spring.cloud.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(description = "书籍评论信息DTO")
public class BookEvaluationDTO {

    public interface UpdateGroup {
    }

    public interface SaveGroup {
    }

    @ApiModelProperty("数据ID")
    @NotNull(groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty("评论者ID")
    @NotEmpty(groups = SaveGroup.class)
    private String commentatorId;

    @ApiModelProperty("书籍ID")
    @NotEmpty(groups = SaveGroup.class)
    private String bookId;

    @ApiModelProperty("评论信息")
    @NotEmpty(groups = SaveGroup.class)
    private String evaluationInfo;

}
