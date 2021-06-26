package com.base.demo.desgin.factory.service.impl;

import com.base.demo.desgin.factory.service.ICacheAdapter;
import com.base.demo.desgin.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @Description: EGM集群的缓存适配器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.factory.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:39
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }

}
