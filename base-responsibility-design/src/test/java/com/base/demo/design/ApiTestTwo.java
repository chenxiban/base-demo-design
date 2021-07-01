package com.base.demo.design;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.model.AuthLink;
import com.base.demo.design.test.AuthService;
import com.base.demo.design.test.impl.Level1AuthLink;
import com.base.demo.design.test.impl.Level2AuthLink;
import com.base.demo.design.test.impl.Level3AuthLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 测试类二
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:09
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTestTwo {

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
    }

}
