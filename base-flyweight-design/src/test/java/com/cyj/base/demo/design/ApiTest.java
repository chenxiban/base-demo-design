package com.cyj.base.demo.design;

import com.alibaba.fastjson.JSON;
import com.cyj.base.demo.design.controller.ActivityController;
import com.cyj.base.demo.design.model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类--一坨坨代码的
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:39
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest {

    private ActivityController activityController = new ActivityController();

    @Test
    public void test_queryActivityInfo() {
        Long req = 10001L;
        Activity activity = activityController.queryActivityInfo(req);
        log.info("测试结果：{} {}", req, JSON.toJSONString(activity));
    }

}
