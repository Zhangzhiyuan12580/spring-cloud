package com.spring.cloud.bookstore.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookEvaluation extends BaseDomain{

    /**
     * 评论者ID
     */
    private Long commentatorId;

    /**
     * 书籍ID
     */
    private Long bookId;

    /**
     * 评论信息
     */
    private String evaluationInfo;
}
