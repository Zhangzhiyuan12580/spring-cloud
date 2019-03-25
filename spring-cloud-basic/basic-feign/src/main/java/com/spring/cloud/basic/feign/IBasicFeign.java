package com.spring.cloud.basic.feign;

import com.spring.cloud.core.basic.UserInfoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zzy
 * @Date 2019-03-23-22:17
 * @Description
 **/

@FeignClient(name = "SPRING-CLOUD-BASIC", fallback = BasicFeignFallBack.class, configuration = BasicFeignConfig.class)
public interface IBasicFeign {

    @RequestMapping(value = "users/findById")
    UserInfoDTO findById(@RequestParam(value = "id") Long id);
}
