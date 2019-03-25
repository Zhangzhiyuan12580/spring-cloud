package com.spring.cloud.bookstore.service;

import com.spring.cloud.core.bookstore.BookEvaluationDTO;

/**
 * @ClassName: IBookEvaluationService
 * @Author: zzy
 * @Date: 2019/3/25 14:50
 * @Version: 1.2
 * @Description:
 */
public interface IBookEvaluationService {

    int delete(Long id);

    int save(BookEvaluationDTO record);

    BookEvaluationDTO findById(Long id);

    int update(BookEvaluationDTO record);

}
