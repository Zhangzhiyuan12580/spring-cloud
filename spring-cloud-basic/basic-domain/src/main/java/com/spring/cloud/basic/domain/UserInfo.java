package com.spring.cloud.basic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * @ClassName: UserInfo
 * @Author: zzy
 * @Date: 2019/3/22 11:07
 * @Version: 1.2
 * @Description:
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseModel {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 电话
     */
    private String phone;

    /**
     * 生日
     */
    private LocalDate birthday;

}


