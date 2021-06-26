package com.base.demo.design.impl;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.dao.ICommodity;
import com.base.demo.design.goods.DeliverReq;
import com.base.demo.design.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Description: 奖品商品服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:49
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class GoodsCommodityService implements ICommodity {

    /**
     * 模拟注入
     */
    private GoodsService goodsService = new GoodsService();

    /**
     * 模拟发放奖品
     *
     * @param uId
     * @param commodityId
     * @param bizId
     * @param extMap
     * @return void
     * @date 2021/6/26 11:01
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    /**
     * 设置用户名称
     *
     * @param uId
     * @return java.lang.String
     * @date 2021/6/26 11:02
     * @author ChenYongJia
     * @version 1.0
     */
    private String queryUserName(String uId) {
        return "小佳";
    }

    /**
     * 设置用户手机号
     *
     * @param uId
     * @return java.lang.String
     * @date 2021/6/26 11:02
     * @author ChenYongJia
     * @version 1.0
     */
    private String queryUserPhoneNumber(String uId) {
        return "15638589820";
    }

}
