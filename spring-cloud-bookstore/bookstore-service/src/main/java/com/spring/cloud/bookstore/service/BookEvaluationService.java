package com.spring.cloud.bookstore.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.spring.cloud.bookstore.domain.BookEvaluation;
import com.spring.cloud.bookstore.dto.BookEvaluationDTO;

public interface BookEvaluationService extends IService<BookEvaluation> {

    int save(BookEvaluationDTO record);

    BookEvaluationDTO findById(Long id);

    int update(BookEvaluationDTO record);

}
