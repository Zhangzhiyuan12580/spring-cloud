package com.spring.cloud.basic.feign;

import feign.Request;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zzy
 * @Date 2019-03-23-23:18
 * @Description
 **/
@Configuration
@EnableFeignClients("com.spring.cloud.basic.feign")
public class BasicFeignConfig {

    @Bean
    public Request.Options feignOption() {
        return new Request.Options(5000, 60000);
    }
}

