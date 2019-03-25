package com.spring.cloud.core.bookstore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author zzy
 * @Date 2019-03-24-10:38
 * @Description
 **/
@EqualsAndHashCode
@Data
@ApiModel(value = "BookDTO", description = "书籍信息DTO")
public class BookDTO {

    @ApiModelProperty("书籍Id")
    private Long id;

    @ApiModelProperty("书名称")
    private String name;

    @ApiModelProperty("书的作者")
    private String authorId;

    @ApiModelProperty("书的作者")
    private String authorName;

    @ApiModelProperty("书类型")
    private String bookType;

    @ApiModelProperty("价格")
    private Double price;
}
