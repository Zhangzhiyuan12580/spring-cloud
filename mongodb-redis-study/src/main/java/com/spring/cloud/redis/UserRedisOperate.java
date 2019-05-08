package com.spring.cloud.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @Author zzy
 * @Date 2019-04-07-18:05
 * @Description
 **/
@Repository
public class UserRedisOperate {

    private static final String USER_KEY_PRE = "springCloud:user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> operations;

    @PostConstruct
    private void init() {
        this.operations = this.redisTemplate.opsForValue();
    }

    /**
     * 保存数据
     *
     * @param userInfoDTO
     */
    public void save(UserInfoDTO userInfoDTO) {
        this.operations.set(this.buildKey(userInfoDTO.getId()), userInfoDTO);
    }

    /**
     * 查询某个
     *
     * @param userId
     * @return
     */
    public UserInfoDTO findOne(Long userId) {
        String key = this.buildKey(userId);
        if (this.redisTemplate.hasKey(key)) {
            return (UserInfoDTO) this.operations.get(key);
        }
        return null;
    }

    /**
     * 删除
     *
     * @param userId
     */
    public void delete(Long userId) {
        this.redisTemplate.delete(this.buildKey(userId));
    }

    /**
     * 构建用户存储的key
     *
     * @param userId
     * @return
     */
    private String buildKey(Long userId) {
        return USER_KEY_PRE + userId;
    }
}
