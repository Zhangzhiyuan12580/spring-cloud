package com.spring.cloud.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(description = "书籍信息DTO")
public class BookDTO {

    @ApiModelProperty("书籍Id")
    private Long id;

    @ApiModelProperty("书名称")
    private String name;

    @ApiModelProperty("书的作者")
    private Long authorId;

    @ApiModelProperty("书的作者")
    private String authorName;

    @ApiModelProperty("书类型")
    private String bookType;

    @ApiModelProperty("价格")
    private BigDecimal price;
}
