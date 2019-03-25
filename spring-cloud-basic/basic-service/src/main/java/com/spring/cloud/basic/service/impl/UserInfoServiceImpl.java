package com.spring.cloud.basic.service.impl;

import com.google.common.collect.Lists;
import com.spring.cloud.basic.dao.UserInfoRepository;
import com.spring.cloud.basic.domain.UserInfo;
import com.spring.cloud.basic.service.IUserInfoService;
import com.spring.cloud.core.basic.UserInfoDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @ClassName: UserInfoServiceImpl
 * @Author: zzy
 * @Date: 2019/3/22 12:33
 * @Version: 1.2
 * @Description:
 */
@Service(value = "userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDTO findById(Long id) throws Exception {
        if (null == id) {
            throw new Exception("查询数据id不能为空");
        }
        UserInfo user = userInfoRepository.findOne(id);
        if (null == user) {
            throw new Exception("不存在id为" + id + "的数据");
        }
        UserInfoDTO dto = new UserInfoDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    @Transactional
    public void save(UserInfoDTO dto) throws Exception {
        if (null == dto) {
            throw new Exception("保存数据不能为空");
        }
        UserInfo user = new UserInfo();
        BeanUtils.copyProperties(dto, user);
        userInfoRepository.save(user);
    }

    @Override
    @Transactional
    public void update(UserInfoDTO dto) throws Exception {
        if (null == dto) {
            throw new Exception("修改数据不能为空");
        }
        if (null == dto.getId()) {
            throw new Exception("修改数据ID不能为空");
        }
        UserInfo user = userInfoRepository.findOne(dto.getId());
        if (null == user) {
            throw new Exception("不存在id为" + dto.getId() + "的数据");
        }
        BeanUtils.copyProperties(dto, user);
        userInfoRepository.save(user);
    }

    @Override
    public List<UserInfoDTO> findList(Sort sort, final String name, final Integer age) {
        List<UserInfoDTO> list = Lists.newArrayList();

        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = Lists.newArrayList();
                if (StringUtils.isNotEmpty(name)) {
                    predicateList.add(criteriaBuilder.like(root.<String>get("userName").as(String.class), "%" + name + "%"));
                }
                if (null != age) {
                    predicateList.add(criteriaBuilder.equal(root.<Integer>get("age").as(Integer.class), age));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        List<UserInfo> userInfos = userInfoRepository.findAll(specification, sort);
        if (CollectionUtils.isNotEmpty(userInfos)) {
            for (UserInfo userInfo : userInfos) {
                UserInfoDTO dto = new UserInfoDTO();
                BeanUtils.copyProperties(userInfo, dto);
                list.add(dto);
            }
        }
        return list;
    }

    @Override
    public Page<UserInfoDTO> findPage(Pageable pageable, final String name, final Integer age) {
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = Lists.newArrayList();
                if (StringUtils.isNotEmpty(name)) {
                    predicateList.add(criteriaBuilder.like(root.<String>get("userName").as(String.class), "%" + name + "%"));
                }
                if (null != age) {
                    predicateList.add(criteriaBuilder.equal(root.<Integer>get("age").as(Integer.class), age));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        Page<UserInfo> userPage = userInfoRepository.findAll(specification, pageable);
        List<UserInfoDTO> list = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userPage.getContent())) {
            for (UserInfo userInfo : userPage.getContent()) {
                UserInfoDTO dto = new UserInfoDTO();
                BeanUtils.copyProperties(userInfo, dto);
                list.add(dto);
            }
        }
        Page<UserInfoDTO> dtoPage = new PageImpl<UserInfoDTO>(list, pageable, userPage.getTotalElements());
        return dtoPage;
    }
}
