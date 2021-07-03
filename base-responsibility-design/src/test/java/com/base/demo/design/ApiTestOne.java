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

    /**
     * 模拟审批
     * <p>
     * 这里模拟每次查询是否审批完成，随着审批的不同节点，之后继续由不同的负责人进行审批操作。
     * <p>
     * authController.doAuth，是查看审批的流程节点、AuthService.auth，是审批方法用于操作节点流程状态。
     * <p>
     * 从测试结果可以看到一层层的由不同的人员进行审批，审批完成后到下一个人进行处理。
     * 单看结果是满足我们的诉求，只不过很难扩展和调整流程，相当于代码写的死死的
     *
     * @return void
     * @date 2021/7/3 10:06
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_AuthController() throws ParseException {
        AuthController authController = new AuthController();

        // 模拟三级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小佳佳", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        AuthService.auth("1000013", "1000998004813441");

        // 模拟二级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小佳佳", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        AuthService.auth("1000012", "1000998004813441");

        // 模拟一级负责人审批
        log.info("测试结果：{}", JSON.toJSONString(authController.doAuth("小佳佳", "1000998004813441", new Date())));
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        AuthService.auth("1000011", "1000998004813441");

        log.info("测试结果：{}", "审批完成");
    }


}
