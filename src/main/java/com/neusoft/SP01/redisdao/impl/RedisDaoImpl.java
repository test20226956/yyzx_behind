package com.neusoft.SP01.redisdao.impl;


import com.neusoft.SP01.redisdao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository//dao层专用注解
public class RedisDaoImpl implements RedisDao {
    @Autowired//注入到Spring容器中
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, String value) {
        ValueOperations vo = redisTemplate.opsForValue();//ValueOperations->存储数据读取数据的方法
        vo.set(key, value);//向redis中存储键值对
    }

    @Override//带过期时间的存储方法
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        ValueOperations vo = redisTemplate.opsForValue();//ValueOperations->存储数据读取数据的方法
        vo.set(key, value,timeout,timeUnit);//向redis中存储键值对
    }

    @Override
    public String get(String key) {
        ValueOperations vo = redisTemplate.opsForValue();//ValueOperations->存储数据读取数据的方法
        Object o = vo.get(key);
        String s = (String) o;//强转一下
        return s;
    }
}
