package com.base.demo.design.coupon;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 模拟优惠券服务
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.coupon
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:35
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class CouponService {

    /**
     * 模拟发放优惠券
     *
     * @param uId 优惠券的用户uid
     * @param couponNumber 优惠券编码
     * @param uuid 唯一id
     * @return com.base.demo.design.coupon.CouponResult
     * @date 2021/6/26 10:39
     * @author ChenYongJia
     * @version 1.0
     */
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        log.info("模拟发放优惠券一张：{},{},{}", uId, couponNumber, uuid);
        return new CouponResult("0000", "发放成功");
    }

}
