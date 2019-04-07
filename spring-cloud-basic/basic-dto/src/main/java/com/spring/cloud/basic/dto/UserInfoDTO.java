package com.spring.cloud.basic.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author zzy
 */
@Data
@NoArgsConstructor
@ApiModel(description = "用户信息DTO")
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 3248875186642703620L;

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
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
}
