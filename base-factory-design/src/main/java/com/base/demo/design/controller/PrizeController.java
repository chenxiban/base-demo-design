package com.base.demo.design.controller;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.Award.AwardReq;
import com.base.demo.design.Award.AwardRes;
import com.base.demo.design.card.IQiYiCardService;
import com.base.demo.design.coupon.CouponResult;
import com.base.demo.design.coupon.CouponService;
import com.base.demo.design.goods.DeliverReq;
import com.base.demo.design.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 模拟发奖服务控制器类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class PrizeController {

    /**
     * 奖励用户
     *
     * @param req 奖品入参
     * @return com.base.demo.design.Award.AwardRes
     * @date 2021/6/26 10:46
     * @author ChenYongJia
     * @version 1.0
     */
    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            log.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            log.info("奖品发放完成{}。", req.getUId());
        } catch (Exception e) {
            log.error("奖品发放失败{}。req:{}", req.getUId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }

        return awardRes;
    }

    /**
     * 设置用户名称为小佳
     *
     * @param uId 用户id
     * @return java.lang.String
     * @date 2021/6/26 10:46
     * @author ChenYongJia
     * @version 1.0
     */
    private String queryUserName(String uId) {
        return "小佳";
    }

    /**
     * 设置用户名手机号码
     *
     * @param uId 用户id
     * @return java.lang.String
     * @date 2021/6/26 10:47
     * @author ChenYongJia
     * @version 1.0
     */
    private String queryUserPhoneNumber(String uId) {
        return "15638589820";
    }

}
