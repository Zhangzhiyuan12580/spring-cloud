package com.spring.cloud.basic.feign;

import com.spring.cloud.basic.dto.UserInfoDTO;
import com.spring.cloud.core.response.RestResponse;
import org.springframework.stereotype.Component;

/**
 * @Author zzy
 * @Date 2019-03-23-22:20
 * @Description
 **/
@Component
public class BasicFeignFallBack implements BasicFeign {
    @Override
    public RestResponse<UserInfoDTO> findById(Long id) {
        return null;
    }
}
