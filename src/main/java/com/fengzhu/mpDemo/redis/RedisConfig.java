package com.fengzhu.mpDemo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 配置 JedisConnectionFactory 用于连接 Redis 服务器
     * @return RedisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 创建 JedisConnectionFactory 实例
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost"); // Redis 服务器地址
        factory.setPort(6379);            // Redis 端口
        factory.setPassword("yourpassword"); // Redis 密码（如果有的话）
        factory.setUsePool(true);        // 使用连接池
        return factory;
    }

    /**
     * 配置 RedisTemplate，用于进行 Redis 数据操作
     * @param factory RedisConnectionFactory
     * @return RedisTemplate 实例
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory); // 设置连接工厂

        // 设置 key 和 value 的序列化方式
        template.setKeySerializer(RedisSerializer.string());          // Key 使用字符串序列化
        template.setValueSerializer(RedisSerializer.json());           // Value 使用 JSON 序列化

        // 设置 hash 的 key 和 value 的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet(); // 初始化 RedisTemplate
        return template;
    }
}
