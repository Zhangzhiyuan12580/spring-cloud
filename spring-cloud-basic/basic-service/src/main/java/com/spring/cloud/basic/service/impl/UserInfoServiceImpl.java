package com.spring.cloud.basic.service.impl;

import com.google.common.collect.Lists;
import com.spring.cloud.basic.dao.UserInfoRepository;
import com.spring.cloud.basic.domain.UserInfo;
import com.spring.cloud.basic.dto.UserInfoDTO;
import com.spring.cloud.basic.service.UserInfoService;
import com.spring.cloud.core.exception.ServiceException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDTO findById(Long id) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(id);
        UserInfo user = userInfoOptional.orElseThrow(() -> new ServiceException("不存在id为" + id + "的数据"));
        UserInfoDTO dto = new UserInfoDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    public void save(UserInfoDTO dto) {
        UserInfo user = new UserInfo();
        BeanUtils.copyProperties(dto, user);
        userInfoRepository.save(user);
    }

    @Override
    public void update(UserInfoDTO dto) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(dto.getId());
        UserInfo user = userInfoOptional.orElseThrow(() -> new ServiceException("不存在id为" + dto.getId() + "的数据"));
        BeanUtils.copyProperties(dto, user);
        userInfoRepository.save(user);
    }

    @Override
    public List<UserInfoDTO> findList(Sort sort, final String name, final Integer age) {
        Specification<UserInfo> specification = getUserInfoSpecification(name, age);
        List<UserInfo> userInfos = userInfoRepository.findAll(specification, sort);
        return userInfos.stream().map(userInfo -> {
            UserInfoDTO dto = new UserInfoDTO();
            BeanUtils.copyProperties(userInfo, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Page<UserInfoDTO> findPage(Pageable pageable, final String name, final Integer age) {
        Specification<UserInfo> specification = getUserInfoSpecification(name, age);
        Page<UserInfo> userPage = userInfoRepository.findAll(specification, pageable);
        return userPage.map(userInfo -> {
            UserInfoDTO dto = new UserInfoDTO();
            BeanUtils.copyProperties(userInfo, dto);
            return dto;
        });
    }

    private Specification<UserInfo> getUserInfoSpecification(String name, Integer age) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = Lists.newArrayList();
            if (StringUtils.isNotEmpty(name)) {
                predicateList.add(criteriaBuilder.like(root.get("userName"), "%" + name + "%"));
            }
            if (age != null) {
                LocalDate startDate = LocalDate.now().minusYears(age);
                LocalDate endDate = LocalDate.now().minusYears(age + 1L);
                predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("birthday"), startDate));
                predicateList.add(criteriaBuilder.lessThan(root.get("age"), endDate));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
