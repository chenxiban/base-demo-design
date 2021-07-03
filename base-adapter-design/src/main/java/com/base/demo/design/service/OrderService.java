package com.base.demo.design.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 订单服务类--查询用户内部下单数量接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:54
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class OrderService {

    /**
     * 查询用户订单是否为首单
     *
     * @param userId 用户id
     * @return long
     * @date 2021/7/3 10:55
     * @author ChenYongJia
     * @version 1.0
     */
    public long queryUserOrderCount(String userId){
        log.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
