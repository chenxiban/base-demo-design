package com.base.demo.desgin.service.impl;

import com.base.demo.desgin.matter.EGM;
import com.base.demo.desgin.matter.IIR;
import com.base.demo.desgin.service.CacheService;
import com.base.demo.desgin.util.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 缓存服务实现类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.cuisine.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:18
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class CacheServiceImpl implements CacheService {

    /**
     * 模拟注入
     */
    private RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();

    /**
     * Redis获取数据
     *
     * @param key 键
     * @return java.lang.String
     * @date 2021/6/26 16:23
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    /**
     * Redis写入数据
     *
     * @param key   键
     * @param value 值
     * @return void
     * @date 2021/6/26 16:23
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    /**
     * Redis写入有过期时间的数据
     *
     * @param key      键
     * @param value    值
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     * @return void
     * @date 2021/6/26 16:24
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    /**
     * Redis删除数据
     *
     * @param key 键
     * @return void
     * @date 2021/6/26 16:24
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void del(String key) {
        redisUtils.del(key);
    }

    // ================== 以下是传统的方式实现业务 ====================

    @Override
    public String get(String key, int redisType) {

        if (1 == redisType) {
            return egm.gain(key);
        }

        if (2 == redisType) {
            return iir.get(key);
        }

        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {

        if (1 == redisType) {
            egm.set(key, value);
            return;
        }

        if (2 == redisType) {
            iir.set(key, value);
            return;
        }

        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {

        if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
            return;
        }

        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key, int redisType) {

        if (1 == redisType) {
            egm.delete(key);
            return;
        }

        if (2 == redisType) {
            iir.del(key);
            return;
        }

        redisUtils.del(key);
    }

}
