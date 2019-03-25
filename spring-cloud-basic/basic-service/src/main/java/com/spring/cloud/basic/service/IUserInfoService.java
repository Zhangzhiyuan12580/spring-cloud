package com.spring.cloud.basic.service;

import com.spring.cloud.core.basic.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @ClassName: IUserInfoService
 * @Author: zzy
 * @Date: 2019/3/22 12:00
 * @Version: 1.2
 * @Description:
 */
public interface IUserInfoService {

    UserInfoDTO findById(Long id) throws Exception;

    void save(UserInfoDTO dto) throws Exception;

    void update(UserInfoDTO dto) throws Exception;

    List<UserInfoDTO> findList(Sort sort, String name, Integer age);

    Page<UserInfoDTO> findPage(Pageable pageable, String name, Integer age);
}
