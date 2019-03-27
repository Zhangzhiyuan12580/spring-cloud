package com.spring.cloud.basic.service;

import com.spring.cloud.core.basic.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserInfoService {

    UserInfoDTO findById(Long id);

    void save(UserInfoDTO dto);

    void update(UserInfoDTO dto);

    List<UserInfoDTO> findList(Sort sort, String name, Integer age);

    Page<UserInfoDTO> findPage(Pageable pageable, String name, Integer age);
}
