package com.spring.cloud.bookstore.mapper;

import com.spring.cloud.bookstore.domain.BookEvaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEvaluationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BookEvaluation record);

    int insertSelective(BookEvaluation record);

    BookEvaluation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookEvaluation record);

    int updateByPrimaryKey(BookEvaluation record);
}