package com.spring.cloud.bookstore.service.impl;

import com.spring.cloud.bookstore.domain.BookEvaluation;
import com.spring.cloud.bookstore.mapper.BookEvaluationMapper;
import com.spring.cloud.bookstore.service.IBookEvaluationService;
import com.spring.cloud.core.bookstore.BookEvaluationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BookEvaluationServiceImpl
 * @Author: zzy
 * @Date: 2019/3/25 14:50
 * @Version: 1.2
 * @Description: 此处代码未加严格判断（只是为了测试mybatis）
 */
@Service(value = "bookEvaluationService")
public class BookEvaluationServiceImpl implements IBookEvaluationService {

    @Autowired
    private BookEvaluationMapper bookEvaluationMapper;

    @Override
    public int delete(Long id) {
        return bookEvaluationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(BookEvaluationDTO record) {
        BookEvaluation evaluation = new BookEvaluation();
        BeanUtils.copyProperties(record, evaluation);
        return bookEvaluationMapper.insert(evaluation);
    }

    @Override
    public BookEvaluationDTO findById(Long id) {
        BookEvaluation evaluation = bookEvaluationMapper.selectByPrimaryKey(id);
        BookEvaluationDTO dto = new BookEvaluationDTO();
        BeanUtils.copyProperties(evaluation, dto);
        return dto;
    }

    @Override
    public int update(BookEvaluationDTO record) {
        BookEvaluation evaluation = new BookEvaluation();
        BeanUtils.copyProperties(record, evaluation);
        return bookEvaluationMapper.updateByPrimaryKey(evaluation);
    }
}
