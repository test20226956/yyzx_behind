package com.neusoft.SP01.redisdao;

import java.util.concurrent.TimeUnit;

public interface RedisDao {
    //向redis中存储数据的方法
    void set(String key,String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    //从redis中读取数据的方法
    String get(String key);
}
