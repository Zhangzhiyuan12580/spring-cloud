package com.spring.cloud.redis;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 3248875186642703620L;

    interface UpdateGroup {
    }

    @NotNull(groups = UpdateGroup.class)
    private Long id;

    private String userName;

    private String idCard;

    private String phone;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
}
