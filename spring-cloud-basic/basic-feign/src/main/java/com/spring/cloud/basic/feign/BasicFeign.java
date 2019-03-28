package com.spring.cloud.basic.feign;

import com.spring.cloud.basic.dto.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SPRING-CLOUD-BASIC", fallback = BasicFeignFallBack.class, configuration = BasicFeignConfig.class)
public interface BasicFeign {

    @RequestMapping("users/findById")
    UserInfoDTO findById(@RequestParam(value = "id") Long id);
}
