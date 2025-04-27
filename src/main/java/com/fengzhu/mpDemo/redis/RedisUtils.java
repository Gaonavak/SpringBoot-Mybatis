package com.fengzhu.mpDemo.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * Redis 工具类，封装了常用的 Redis 操作方法。
 */
@Slf4j
@Component("redisUtils")
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate; // 注入 RedisTemplate

    // 删除指定的 Redis 键
    public void delete(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(Arrays.asList(keys));
            }
        }
    }

    // 获取指定键的值
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    // 设置指定键的值
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置 Redis 键失败, 键：{}, 值：{}", key, value);
            return false;
        }
    }

    // 设置指定键的值，并设置过期时间
    public boolean setex(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("设置 Redis 键失败, 键：{}, 值：{}", key, value);
            return false;
        }
    }

    // 设置指定键的过期时间
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 获取列表中的所有元素
    public List<Object> getQueueList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    // 向列表左侧推送元素
    public boolean lpush(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
