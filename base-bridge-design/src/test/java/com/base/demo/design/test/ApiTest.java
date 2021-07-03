package com.base.demo.design.test;

import com.base.demo.design.controller.PayController;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Description: 测试类--一把梭
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:19
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ApiTest {

    /**
     * 分别测试了两种不同的支付类型和支付模式；微信人脸支付、支付宝指纹支付
     * <p>
     * 可以从测试结果看出满足了我们的不同支付类型和支付模式的组合，但是这样的代码在后面的维护以及扩展都会变得非常复杂。
     *
     * @return void
     * @date 2021/7/3 16:20
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_pay() {
        PayController pay = new PayController();

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
    }

}
