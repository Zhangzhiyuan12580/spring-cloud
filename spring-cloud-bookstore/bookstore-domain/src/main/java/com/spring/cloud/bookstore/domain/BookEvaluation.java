package com.spring.cloud.bookstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class BookEvaluation {

    /**
     * 数据ID
     */
    private Long id;

    /**
     * 评论者ID
     */
    private String commentatorId;

    /**
     * 书籍ID
     */
    private String bookId;

    /**
     * 评论信息
     */
    private String evaluationInfo;
}