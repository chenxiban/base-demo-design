package com.base.demo.design.impl;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.coupon.CouponResult;
import com.base.demo.design.coupon.CouponService;
import com.base.demo.design.dao.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Description: 优惠券服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class CouponCommodityService implements ICommodity {

    /**
     * 模拟注入
     */
    private CouponService couponService = new CouponService();

    /**
     * 模拟发放奖品
     *
     * @param uId
     * @param commodityId
     * @param bizId
     * @param extMap
     * @return void
     * @date 2021/6/26 10:56
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));

        String res = "0000";
        if (!res.equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }

}
