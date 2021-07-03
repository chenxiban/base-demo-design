package com.base.demo.design.test;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.event.service.LotteryService;
import com.base.demo.design.event.service.impl.LotteryServiceImpl;
import com.base.demo.design.result.LotteryResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类--设计模式的测试
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:58
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest2 {

    /**
     * 从调用上来看几乎没有区别，但是这样的实现方式就可以非常方便的维护代码以及扩展新的需求。
     * <p>
     * 从测试结果上看满足😌我们的预期，虽然结果是一样的，但只有我们知道了设计模式的魅力所在。
     *
     * @return void
     * @date 2021/7/3 15:59
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        log.info("测试结果：{}", JSON.toJSONString(result));
    }

}
