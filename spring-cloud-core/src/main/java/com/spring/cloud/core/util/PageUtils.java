package com.spring.cloud.core.util;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageUtils {

    public static <T, R> PageInfo<R> transfer(PageInfo<T> source, Function<T, R> mapper) {
        List<R> collect = source.getList().stream().map(mapper).collect(Collectors.toList());
        PageInfo<R> target = new PageInfo<>();
        BeanUtils.copyProperties(source, target);
        target.setList(collect);
        return target;
    }

}
