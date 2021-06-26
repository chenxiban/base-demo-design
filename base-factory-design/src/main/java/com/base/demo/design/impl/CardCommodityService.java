package com.base.demo.design.impl;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.card.IQiYiCardService;
import com.base.demo.design.dao.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Description: 爱奇艺卡片服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:48
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class CardCommodityService implements ICommodity {

    /**
     * 模拟注入
     */
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    /**
     * 模拟发放优惠卡片
     *
     * @param uId 用户id
     * @param commodityId 货物id
     * @param bizId
     * @param extMap
     * @return void
     * @date 2021/6/26 10:53
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    /**
     * 设置用户手机号
     *
     * @param uId 用户id
     * @return java.lang.String
     * @date 2021/6/26 10:53
     * @author ChenYongJia
     * @version 1.0
     */
    private String queryUserMobile(String uId) {
        return "15638589820";
    }

}
