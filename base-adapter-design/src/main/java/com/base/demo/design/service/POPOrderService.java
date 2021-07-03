package com.base.demo.design.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 订单妥投服务类--查询用户第三方下单首单接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:55
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class POPOrderService {

    /**
     * 查询用户的订单是否为首单
     *
     * @param uId 用户id
     * @return boolean
     * @date 2021/7/3 10:56
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean isFirstOrder(String uId) {
        log.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }

}
