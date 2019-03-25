package com.spring.cloud.basic.controller;

import com.spring.cloud.basic.service.IUserInfoService;
import com.spring.cloud.core.basic.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zzy
 * @Date 2019-03-23-21:07
 * @Description 用户相关Api
 **/

@Slf4j
@Api(value = "UserInfoController", description = "用户相关Api")
@RestController
@RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST})
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @ApiOperation(value = "用户分页接口", notes = "用户分页接口", httpMethod = "GET", tags = "用户相关Api")
    @GetMapping(value = "pageList")
    public Page<UserInfoDTO> pageList(@ApiParam(value = "名称") @RequestParam(required = false) String name,
                                      @ApiParam(value = "年龄") @RequestParam(required = false) Integer age,
                                      @ApiParam(value = "第几页，从0开始") @RequestParam(required = false, defaultValue = "0") Integer page,
                                      @ApiParam(value = "每页多少个") @RequestParam(required = false, defaultValue = "10") Integer size,
                                      @ApiParam(value = "排序字段") @RequestParam(required = false, defaultValue = "age") String sort) {

        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, sort);
        return userInfoService.findPage(pageable, name, age);
    }


    @ApiOperation(value = "用户列表接口", notes = "用户列表接口", httpMethod = "GET", tags = "用户相关Api")
    @GetMapping(value = "list")
    public List<UserInfoDTO> list(@ApiParam(value = "名称") @RequestParam(required = false) String name,
                                  @ApiParam(value = "年龄") @RequestParam(required = false) Integer age,
                                  @ApiParam(value = "排序字段") @RequestParam(required = false, defaultValue = "age") String sort) {

        return userInfoService.findList(new Sort(Sort.Direction.ASC, sort), name, age);
    }

    @ApiOperation(value = "用户保存接口", notes = "用户保存接口", httpMethod = "POST", tags = "用户相关Api")
    @PostMapping(value = "save")
    public void save(@ApiParam(value = "用户基础信息", required = true) @RequestBody UserInfoDTO dto) throws Exception {
        userInfoService.save(dto);

    }

    @ApiOperation(value = "用户修改接口", notes = "用户修改接口", httpMethod = "POST", tags = "用户相关Api")
    @PostMapping(value = "update")
    public void update(@ApiParam(value = "用户基础信息", required = true) @RequestBody UserInfoDTO dto) throws Exception {
        userInfoService.update(dto);

    }

    @ApiOperation(value = "用户修改接口", notes = "用户修改接口", httpMethod = "POST", tags = "用户相关Api")
    @GetMapping(value = "findById")
    public UserInfoDTO findById(@ApiParam(value = "用户ID", required = true) Long id) throws Exception {
        return userInfoService.findById(id);
    }
}
