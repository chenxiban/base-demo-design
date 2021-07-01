package com.base.demo.design.test.context;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Description: 上下文
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.context
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:30
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 折算后的价格
     *
     * @param couponInfo 优惠券信息
     * @param skuPrice   sku价格
     * @return java.math.BigDecimal
     * @date 2021/7/1 17:31
     * @author ChenYongJia
     * @version 1.0
     */
    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
