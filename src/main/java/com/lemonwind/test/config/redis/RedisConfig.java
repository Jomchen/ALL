package com.lemonwind.test.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * create by lemonwind on 2018/12/27
 */
@Configuration
public class RedisConfig {

    @Bean("stringRedisTemplate")
    public  RedisTemplate<String, String> stringRedisTemplate(@Autowired RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        /*RedisSerializer<?> redisSerializer = new GenericFastJsonRedisSerializer();*/
        GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(String.class);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(genericToStringSerializer);
        return redisTemplate;
    }

}
