package com.base.demo.design.dao;

import java.util.Map;

/**
 * @Description: 我的商品接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.dao
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:51
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface ICommodity {

    /**
     * 发放奖品、商品
     *
     * @param uId 用户id
     * @param commodityId 商品id
     * @param bizId
     * @param extMap
     * @return void
     * @date 2021/6/26 10:51
     * @author ChenYongJia
     * @version 1.0
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
