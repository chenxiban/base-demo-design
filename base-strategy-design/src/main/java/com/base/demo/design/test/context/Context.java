package com.base.demo.design.test.context;

import com.base.demo.design.test.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @Description: 策略控制类上下文
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.context
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:30
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Context<T> {

    /**
     * 策略模式的控制类主要是外部可以传递不同的策略实现，在通过统一的方法执行优惠策略计算。
     * <p>
     * 另外这里也可以包装成 map 结构，让外部只需要对应的泛型类型即可使用相应的服务。
     */
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    /**
     * 折算后的价格--泛型的使用可以传递不同的类型参数。
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
