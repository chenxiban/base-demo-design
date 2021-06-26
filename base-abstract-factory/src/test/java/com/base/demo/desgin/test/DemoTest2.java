package com.base.demo.desgin.test;

import com.base.demo.desgin.factory.JDKProxy;
import com.base.demo.desgin.factory.service.impl.EGMCacheAdapter;
import com.base.demo.desgin.factory.service.impl.IIRCacheAdapter;
import com.base.demo.desgin.service.CacheService;
import com.base.demo.desgin.service.impl.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 模拟测试类2
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:41
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class DemoTest2 {

    @Test
    public void test_CacheService() throws Exception {

        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小佳佳");
        String val01 = proxy_EGM.get("user_name_01");
        log.info("测试结果：" + val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小佳佳");
        String val02 = proxy_IIR.get("user_name_01");
        log.info("测试结果：" + val02);

    }

}
