package com.spring.cloud.basic.service;

import com.spring.cloud.basic.dto.UserInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserInfoService {

    @Cacheable
    UserInfoDTO findById(Long id);

    void save(UserInfoDTO dto);

    void update(UserInfoDTO dto);

    List<UserInfoDTO> findList(Sort sort, String name, Integer age);

    Page<UserInfoDTO> findPage(Pageable pageable, String name, Integer age);
}
