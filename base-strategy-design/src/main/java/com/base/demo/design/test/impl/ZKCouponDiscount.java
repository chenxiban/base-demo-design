package com.base.demo.design.test.impl;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Description: 折扣类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:33
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 折扣计算
     * 1. 使用商品价格乘以折扣比例，为最后支付金额
     * 2. 保留两位小数
     * 3. 最低支付金额1元
     *
     * @param couponInfo
     * @param skuPrice
     * @return java.math.BigDecimal
     * @date 2021/7/1 17:35
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}
