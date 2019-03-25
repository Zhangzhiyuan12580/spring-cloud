package com.spring.cloud.basic.dao;

import com.spring.cloud.basic.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: IUserInfoRepository
 * @Author: zzy
 * @Date: 2019/3/22 11:32
 * @Version: 1.2
 * @Description:
 */
public interface UserInfoRepository
        extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
}
