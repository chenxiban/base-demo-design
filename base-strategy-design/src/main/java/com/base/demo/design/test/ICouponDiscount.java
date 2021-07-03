package com.base.demo.design.test;

import java.math.BigDecimal;

/**
 * @Description: 优惠券折算计算接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:30
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠券金额计算
     * <p>
     * 定义了优惠券折扣接口，也增加了泛型用于不同类型的接口可以传递不同的类型参数。
     * <p>
     * 接口中包括商品金额以及出参返回最终折扣后的金额，这里在实际开发中会比现在的接口参数多一些，但核心逻辑是这些。
     *
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return 优惠后金额
     * @date 2021/7/1 17:31
     * @author ChenYongJia
     * @version 1.0
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
