package com.neusoft.SP01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration//整合Redis的配置类
public class RedisTemplateConfig {
    // 建立一个方法，返回RedisTemplate类型对象
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory rcf)
    {
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);//连接工厂
// 配置键序列化器（把任何类型的key都转为String）
        StringRedisSerializer keySerializer=new StringRedisSerializer();
// 配置值序列化器(把任何值转为json字符串)
        Jackson2JsonRedisSerializer valueSerializer=new
                Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        return redisTemplate;
    }
}
