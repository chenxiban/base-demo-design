package com.base.demo.design.test.impl;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Description: 直接减免类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:33
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     *
     * @param couponInfo
     * @param skuPrice
     * @return java.math.BigDecimal
     * @date 2021/7/1 17:34
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}
