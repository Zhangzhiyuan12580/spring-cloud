package com.spring.cloud.bookstore.mapper;

import com.spring.cloud.bookstore.domain.Book;
import org.springframework.stereotype.Repository;

/**
 * @Author zzy
 * @Date 2019-03-24-10:22
 * @Description
 **/
@Repository
public interface BookMapper {
    /**
     * findOneById
     *
     * @param id
     * @return
     */
    Book findOne(Long id);
}
