package com.spring.cloud.bookstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends BaseDomain{

    /**
     * 书名称
     */
    private String name;

    /**
     * 书的作者
     */
    private Long authorId;

    /**
     * 书类型
     */
    private Long bookTypeId;

    /**
     * 价格
     */
    private BigDecimal price;
}
