package com.base.demo.design.test;

import com.base.demo.design.channel.Pay;
import com.base.demo.design.channel.WxPay;
import com.base.demo.design.channel.ZfbPay;
import com.base.demo.design.mode.PayFaceMode;
import com.base.demo.design.mode.PayFingerprintMode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Description: 测试类--测试设计模式
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:29
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ApiTest2 {

    /**
     * 与if-else实现方式相比，这里的调用方式变得整洁、干净、易使用；new WxPay(new PayFaceMode())、new ZfbPay(new PayFingerprintMode())
     * <p>
     * 外部的使用接口的用户不需要关心具体的实现，只按需选择使用即可。
     * <p>
     * 目前以上优化主要针对桥接模式的使用进行重构if逻辑部分，关于调用部分可以使用抽象工厂或策略模式配合map结构，将服务配置化。
     * 因为这里主要展示桥接模式，所以就不在额外多加代码，避免喧宾夺主。
     * <p>
     * 从测试结果看内容是一样的，但是整体的实现方式有了很大的变化。所以有时候不能只看结果，也要看看过程
     *
     * @return void
     * @date 2021/7/3 16:29
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }

}
