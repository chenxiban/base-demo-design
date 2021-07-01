package com.base.demo.design.test.impl;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Description: 几元买类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:32
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
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
        return new BigDecimal(couponInfo);
    }

}
