package com.spring.cloud.bookstore.config;

import com.spring.cloud.core.exception.ServiceException;
import com.spring.cloud.core.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public RestResponse serviceExceptionHandler(HttpServletRequest request, ServiceException e) {
        log.error("ServiceException Handler---Host: {} invokes url: {} ERROR: {} message: {}",
                request.getRemoteHost(), request.getRequestURL(), e, e.getMessage());
        RestResponse restResponse = RestResponse.of(e.getHttpStatus());
        restResponse.setMessage(e.getMessage());
        return restResponse;
    }

    @ExceptionHandler(Exception.class)
    public RestResponse exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("Exception Handler---Host: {} invokes url: {} ERROR: {}",
                request.getRemoteHost(), request.getRequestURL(), e);
        return RestResponse.fail("Sorry, 服务器好像抽风了, 程序员小伙伴正在疯狂抢救！");
    }

}
