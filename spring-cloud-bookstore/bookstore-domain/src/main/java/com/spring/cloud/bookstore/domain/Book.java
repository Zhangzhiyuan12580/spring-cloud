package com.spring.cloud.bookstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author zzy
 * @Date 2019-03-24-10:15
 * @Description
 **/
@EqualsAndHashCode
@Data
public class Book {

    private Long id;

    /**
     * 书名称
     */
    private String name;

    /**
     * 书的作者
     */
    private String authorId;

    /**
     * 书类型
     */
    private String bookType;

    /**
     * 价格
     */
    private Double price;
}
