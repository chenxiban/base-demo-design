package com.base.demo.design;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.controller.AuthController;
import com.base.demo.design.test.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 测试类一
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:10
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTestOne {

    @Test
    public void test_AuthController() throws ParseException {
        AuthController authController = new AuthController();

        // 模拟三级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        AuthService.auth("1000013", "1000998004813441");

        // 模拟二级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        AuthService.auth("1000012", "1000998004813441");

        // 模拟一级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        AuthService.auth("1000011", "1000998004813441");

        log.info("测试结果：{}", "审批完成");
    }


}
