package com.base.demo.desgin.factory.service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 我的缓存适配器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.factory.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:38
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
