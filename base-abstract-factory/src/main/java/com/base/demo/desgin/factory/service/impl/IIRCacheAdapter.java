package com.base.demo.desgin.factory.service.impl;

import com.base.demo.desgin.factory.service.ICacheAdapter;
import com.base.demo.desgin.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @Description: IIR集群的缓存适配器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.factory.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:39
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }

    public void set(String key, String value) {
        iir.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        iir.del(key);
    }

}
