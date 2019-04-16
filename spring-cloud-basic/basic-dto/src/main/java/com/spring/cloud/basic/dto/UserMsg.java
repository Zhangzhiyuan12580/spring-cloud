package com.spring.cloud.basic.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zzy
 * @Date 2019-04-08-21:00
 * @Description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户信息发送kafkaDTO")
public class UserMsg {

    @ApiModelProperty("变更用户ID")
    private Long userId;

    @ApiModelProperty("变更事件类型")
    private String action;
}
