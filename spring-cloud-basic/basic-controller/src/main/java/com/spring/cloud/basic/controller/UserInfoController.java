package com.spring.cloud.basic.controller;

import com.spring.cloud.basic.service.UserInfoService;
import com.spring.cloud.core.basic.UserInfoDTO;
import com.spring.cloud.core.response.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "用户相关Api")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @ApiOperation(value = "用户分页接口", notes = "用户分页接口", tags = "用户相关Api")
    @GetMapping("pageList")
    public Page<UserInfoDTO> pageList(@ApiParam("名称") String name,
                                      @ApiParam("年龄") Integer age,
                                      Pageable pageable) {
        return userInfoService.findPage(pageable, name, age);
    }


    @ApiOperation(value = "用户列表接口", notes = "用户列表接口", tags = "用户相关Api")
    @GetMapping("list")
    public RestResponse<List<UserInfoDTO>> list(@ApiParam("名称") String name,
                                                @ApiParam("年龄") Integer age,
                                                @ApiParam("排序字段") @RequestParam(required = false, defaultValue = "age") String sort) {
        List<UserInfoDTO> list = userInfoService.findList(Sort.by(sort), name, age);
        return RestResponse.ok(list);
    }

    @ApiOperation(value = "用户保存接口", notes = "用户保存接口", tags = "用户相关Api")
    @PostMapping("save")
    public RestResponse save(@ApiParam(value = "用户基础信息", required = true) @RequestBody UserInfoDTO dto) {
        userInfoService.save(dto);
        return RestResponse.OK;
    }

    @ApiOperation(value = "用户修改接口", notes = "用户修改接口", tags = "用户相关Api")
    @PostMapping("update")
    public RestResponse update(@ApiParam(value = "用户基础信息", required = true) @RequestBody @Validated(UserInfoDTO.UserInfoUpdateGroup.class) UserInfoDTO dto) {
        userInfoService.update(dto);
        return RestResponse.OK;
    }

    @ApiOperation(value = "用户修改接口", notes = "用户修改接口", tags = "用户相关Api")
    @GetMapping("findById")
    public RestResponse<UserInfoDTO> findById(@ApiParam(value = "用户ID", required = true) @RequestParam Long id) {
        return RestResponse.ok(userInfoService.findById(id));
    }
}
