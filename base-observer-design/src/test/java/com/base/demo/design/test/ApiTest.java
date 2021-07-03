package com.base.demo.design.test;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.result.LotteryResult;
import com.base.demo.design.service.LotteryService;
import com.base.demo.design.service.impl.LotteryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest {

    /**
     * 
     * @return void
     * @date 2021/7/3 15:51
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2765789109876");
        log.info("测试结果：{}", JSON.toJSONString(result));
    }


}
