package com.base.demo.design.test;

import com.base.demo.design.test.context.Context;
import com.base.demo.design.test.impl.MJCouponDiscount;
import com.base.demo.design.test.impl.NYGCouponDiscount;
import com.base.demo.design.test.impl.ZJCouponDiscount;
import com.base.demo.design.test.impl.ZKCouponDiscount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:35
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest {

    /**
     * 测试直接减免
     *
     * @return void
     * @date 2021/7/1 17:36
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_zj() {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        log.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    /**
     * 测试满减
     *
     * @return void
     * @date 2021/7/1 17:36
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_mj() {
        // 满100减10，商品100元
        Context<Map<String, String>> context = new Context<>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        log.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    /**
     * 测试折扣
     *
     * @return void
     * @date 2021/7/1 17:36
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        log.info("测试结果：折扣9折后金额 {}", discountAmount);
    }

    /**
     * 测试n元减免
     *
     * @return void
     * @date 2021/7/1 17:36
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        log.info("测试结果：n元购优惠后金额 {}", discountAmount);
    }

}
