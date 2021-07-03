package com.base.demo.design.test;

import com.base.demo.design.utils.model.enums.SelectTypeEnum;

/**
 * @Description: 优惠券折扣计算接口
 * <p>
 * 优惠券类型；
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:28
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class CouponDiscountService {

    /**
     * 优惠券折扣计算接口--这里也可以结合其他设计模式干掉if-else
     * <p>
     * 以下是不同类型的优惠券计算折扣后的实际金额。
     * <p>
     * 入参包括；优惠券类型、优惠券金额、商品金额，因为有些优惠券是满多少减少多少，所以增加了typeExt类型。这也是方法的不好扩展性问题。
     * <p>
     * 最后是整个的方法体中对优惠券抵扣金额的实现，最开始可能是一个最简单的优惠券，后面随着产品功能的增加，不断的扩展if语句。实际的代码可能要比这个多很多。
     *
     * @param type        券类型
     * @param typeContent 券内容
     * @param skuPrice    券折扣价格
     * @param typeExt
     * @return double
     * @date 2021/7/1 17:28
     * @author ChenYongJia
     * @version 1.0
     */
    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1. 直减券
        if (SelectTypeEnum.TYPE_ONE.getCode() == type) {
            return skuPrice - typeContent;
        }
        // 2. 满减券
        if (SelectTypeEnum.TYPE_TWO.getCode() == type) {
            if (skuPrice < typeExt) return skuPrice;
            return skuPrice - typeContent;
        }
        // 3. 折扣券
        if (SelectTypeEnum.TYPE_THREE.getCode() == type) {
            return skuPrice * typeContent;
        }
        // 4. n元购
        if (SelectTypeEnum.TYPE_FOUR.getCode() == type) {
            return typeContent;
        }
        return 0D;
    }

}
