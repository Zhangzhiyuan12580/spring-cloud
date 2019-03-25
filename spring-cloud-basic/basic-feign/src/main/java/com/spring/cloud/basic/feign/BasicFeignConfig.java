package com.spring.cloud.basic.feign;

import feign.Request;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zzy
 * @Date 2019-03-23-23:18
 * @Description
 **/

@Configuration
@EnableFeignClients(basePackages = {"com.spring.cloud.basic.feign"})
public class BasicFeignConfig {

    @Bean
    public Request.Options feginOption() {
        Request.Options option = new Request.Options(5000, 60000);
        return option;
    }
}

