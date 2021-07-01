package com.base.demo.design.test.impl;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Description: 满减类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:32
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

    /**
     * 满减计算
     * 1. 判断满足x元后-n元，否则不减
     * 2. 最低支付金额1元
     *
     * @param couponInfo
     * @param skuPrice
     * @return java.math.BigDecimal
     * @date 2021/7/1 17:33
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        // 小于商品金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // 减去优惠金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }

}
