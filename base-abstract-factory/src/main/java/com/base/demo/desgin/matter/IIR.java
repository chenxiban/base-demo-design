package com.base.demo.desgin.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 模拟集群 IIR
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.matter
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:17
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class IIR {

    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String get(String key) {
        log.info("IIR获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("IIR写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("IIR写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        log.info("IIR删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
