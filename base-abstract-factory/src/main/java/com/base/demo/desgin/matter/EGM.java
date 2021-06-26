package com.base.demo.desgin.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 模拟集群 EGM
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.matter
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:17
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class EGM {

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String gain(String key) {
        log.info("EGM获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("EGM写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("EGM写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        log.info("EGM删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
