package com.base.demo.desgin.test;

import com.base.demo.desgin.service.CacheService;
import com.base.demo.desgin.service.impl.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试传统方式的业务实现
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:33
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class DemoTest {

    /**
     * 测试一波
     *
     * @return void
     * @date 2021/6/26 16:34
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_CacheService() {
        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name_01", "陈小佳", 1);
        String val01 = cacheService.get("user_name_01", 1);
        log.info("测试结果：{}", val01);
    }

}
