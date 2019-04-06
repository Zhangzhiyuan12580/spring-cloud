package com.spring.cloud.basic.controller;

import com.spring.cloud.core.response.RestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zzy
 * @Date 2019-04-05-16:31
 * @Description
 **/
@RestController
@RefreshScope
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public RestResponse<String> hello() {
        return RestResponse.ok(port);
    }
}
