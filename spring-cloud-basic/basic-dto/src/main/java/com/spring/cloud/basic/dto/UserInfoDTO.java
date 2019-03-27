package com.spring.cloud.basic.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@ApiModel(description = "用户信息DTO")
public class UserInfoDTO {

    public interface UpdateGroup {
    }

    @ApiModelProperty("用户Id")
    @NotNull(groups = UpdateGroup.class)
    private Long id;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("身份证")
    private String idCard;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("生日")
    private LocalDate birthday;
}
