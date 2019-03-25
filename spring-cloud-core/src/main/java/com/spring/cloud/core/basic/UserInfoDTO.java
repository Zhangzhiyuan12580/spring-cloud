package com.spring.cloud.core.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: UserInfoDTO
 * @Author: zzy
 * @Date: 2019/3/22 12:34
 * @Version: 1.2
 * @Description:
 */
@Data
@ApiModel(value = "UserInfoDTO", description = "用户信息DTO")
public class UserInfoDTO {

    @ApiModelProperty("用户Id")
    private Long id;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("身份证")
    private String idCard;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("年龄")
    private Integer age;
}
