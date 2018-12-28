package com.jomchen.test.config.redis;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * create by Jomchen on 2018/12/27
 */
@Component
public class RedisService {

    @Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate<String, String> stringRedisTemplate;

    /**
     * 保存对象
     */
    public void saveEntity(String key, Object data) {
        String jsonData = JSONObject.toJSONString(data);
        stringRedisTemplate.opsForValue().set(key, jsonData);
    }

    /**
     * 保存有实效性的对象
     */
    public void saveEntity(
            String key,
            Object data,
            long time,
            TimeUnit timeUnit) {
        String jsonData = JSONObject.toJSONString(data);
        stringRedisTemplate.opsForValue().set(key, jsonData, time, timeUnit);
    }

    /**
     * 移除数据
     */
    public boolean remove(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 获取对象
     */
    public <T> T getEntity(String key, TypeReference<T> typeReference) {
        String data = stringRedisTemplate.opsForValue().get(key);
        if (null == data) { return null; };
        return JSONObject.parseObject(data, typeReference);
    }

}
