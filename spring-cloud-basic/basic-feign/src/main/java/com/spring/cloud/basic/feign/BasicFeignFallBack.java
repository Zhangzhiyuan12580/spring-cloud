package com.spring.cloud.basic.feign;

import com.spring.cloud.core.basic.UserInfoDTO;
import org.springframework.stereotype.Component;

/**
 * @Author zzy
 * @Date 2019-03-23-22:20
 * @Description
 **/
@Component
public class BasicFeignFallBack implements IBasicFeign {
    @Override
    public UserInfoDTO findById(Long id) {
        return null;
    }
}