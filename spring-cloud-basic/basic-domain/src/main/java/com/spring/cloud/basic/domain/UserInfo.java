package com.spring.cloud.basic.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: UserInfo
 * @Author: zzy
 * @Date: 2019/3/22 11:07
 * @Version: 1.2
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

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
     * 年龄
     */
    private Integer age;

}


