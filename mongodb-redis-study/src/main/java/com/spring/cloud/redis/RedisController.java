package com.spring.cloud.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private UserRedisOperate userRedisOperate;

    @PostMapping(value = "save")
    public void save(@RequestBody UserInfoDTO dto) {
        userRedisOperate.save(dto);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody UserInfoDTO dto) {
        userRedisOperate.save(dto);
    }

    @GetMapping(value = "delete")
    public void delete(Long id) {
        userRedisOperate.delete(id);
    }

    @GetMapping(value = "findOne")
    public UserInfoDTO findOne(Long id) {
        return userRedisOperate.findOne(id);
    }
}
