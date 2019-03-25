package com.spring.cloud.bookstore.controller;

import com.spring.cloud.basic.feign.IBasicFeign;
import com.spring.cloud.core.basic.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zzy
 * @Date 2019-03-23-22:28
 * @Description
 **/
@Slf4j
@Api(value = "UserFeignTestController", description = "用户Feign Test")
@RestController
@RequestMapping(value = "/users/feign", method = {RequestMethod.GET, RequestMethod.POST})
public class UserFeignTestController {

    @Resource
    private IBasicFeign basicFeign;

    @ApiOperation(value = "用户修改接口", notes = "用户修改接口", httpMethod = "POST", tags = "用户相关Api")
    @GetMapping(value = "findById")
    public UserInfoDTO findById(@ApiParam(value = "用户ID", required = true) Long id) throws Exception {
        return basicFeign.findById(id);
    }
}
