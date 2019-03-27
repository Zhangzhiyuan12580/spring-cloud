package com.spring.cloud.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.cloud.bookstore.domain.BookEvaluation;
import com.spring.cloud.bookstore.dto.BookEvaluationDTO;
import com.spring.cloud.bookstore.mapper.BookEvaluationMapper;
import com.spring.cloud.bookstore.service.BookEvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookEvaluationServiceImpl extends ServiceImpl<BookEvaluationMapper, BookEvaluation> implements BookEvaluationService {

    @Override
    public int save(BookEvaluationDTO record) {
        BookEvaluation evaluation = new BookEvaluation();
        BeanUtils.copyProperties(record, evaluation);
        return baseMapper.insert(evaluation);
    }

    @Override
    public BookEvaluationDTO findById(Long id) {
        BookEvaluation evaluation = baseMapper.selectById(id);
        BookEvaluationDTO dto = new BookEvaluationDTO();
        BeanUtils.copyProperties(evaluation, dto);
        return dto;
    }

    @Override
    public int update(BookEvaluationDTO record) {
        BookEvaluation evaluation = new BookEvaluation();
        BeanUtils.copyProperties(record, evaluation);
        return baseMapper.updateById(evaluation);
    }
}
