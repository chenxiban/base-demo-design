package com.base.demo.desgin.service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 模拟缓存服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:20
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface CacheService {

    /**
     * 模拟获取数据
     *
     * @param key 键
     * @return java.lang.String
     * @date 2021/6/26 16:25
     * @author ChenYongJia
     * @version 1.0
     */
    String get(final String key);

    /**
     * 模拟写入数据
     *
     * @param key   键
     * @param value 值
     * @return void
     * @date 2021/6/26 16:25
     * @author ChenYongJia
     * @version 1.0
     */
    void set(String key, String value);

    /**
     * 模拟带国旗事件的数据写入
     *
     * @param key      键
     * @param value    值
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     * @return void
     * @date 2021/6/26 16:25
     * @author ChenYongJia
     * @version 1.0
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit);

    /**
     * 模拟删除数据
     *
     * @param key 键
     * @return void
     * @date 2021/6/26 16:26
     * @author ChenYongJia
     * @version 1.0
     */
    void del(String key);

    // ================== 以下是传统的方式实现业务 ====================

    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);

}
