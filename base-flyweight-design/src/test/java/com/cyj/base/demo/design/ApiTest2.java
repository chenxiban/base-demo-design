package com.cyj.base.demo.design;

import com.alibaba.fastjson.JSON;
import com.cyj.base.demo.design.controller.ActivityController2;
import com.cyj.base.demo.design.model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类--测试享元设计模式
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:51
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest2 {

    private ActivityController2 activityController = new ActivityController2();

    /**
     * 可以仔细看下stock部分的库存是一直在变化的，其他部分是活动信息，是固定的，所以我们使用享元模式来将这样的结构进行拆分。
     *
     * @return void
     * @date 2021/8/2 10:52
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_queryActivityInfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            log.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
    }

}
