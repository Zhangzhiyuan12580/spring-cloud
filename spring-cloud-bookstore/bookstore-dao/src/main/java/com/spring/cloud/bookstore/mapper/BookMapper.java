package com.spring.cloud.bookstore.mapper;

import com.spring.cloud.bookstore.domain.Book;
import com.spring.cloud.core.bookstore.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author zzy
 * @Date 2019-03-24-10:22
 * @Description
 **/
@Mapper
public interface BookMapper {
    /**
     * findOneById
     *
     * @param id
     * @return
     */
    Book findOne(Long id);

    /**
     * 分页接口
     *
     * @param book
     * @return
     */
    List<BookDTO> findPage(BookDTO book);
}
