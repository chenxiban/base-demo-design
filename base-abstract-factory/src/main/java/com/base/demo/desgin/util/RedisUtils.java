package com.base.demo.desgin.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 模拟单机服务 RedisUtils 1.模拟Redis功能，也就是假定目前所有的系统都在使用的服务 2.类和方法名次都固定写死到各个业务系统中，改动略微麻烦
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.util
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:21
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class RedisUtils {

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String get(String key) {
        log.info("Redis获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("Redis写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("Redis写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        log.info("Redis删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
