package com.fengzhu.mpDemo.redis;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Redis 组件类，用于处理 Redis 中用户信息等数据的操作。
 */
@Component("redisComponent")
public class RedisComponent {

    @Resource
    private RedisUtils redisUtils; // 注入 Redis 工具类

    // 设置用户信息到 Redis
    public boolean setUserInfo(String key, Object value) {
        return redisUtils.set(key, value);
    }

    // 获取用户信息
    public Object getUserInfo(String key) {
        return redisUtils.get(key);
    }

    // 删除用户信息
    public void deleteUserInfo(String key) {
        redisUtils.delete(key);
    }
}
