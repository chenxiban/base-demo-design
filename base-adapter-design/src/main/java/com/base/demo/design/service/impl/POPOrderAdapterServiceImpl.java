package com.base.demo.design.service.impl;

import com.base.demo.design.service.OrderAdapterService;
import com.base.demo.design.service.POPOrderService;

/**
 * @Description: 第三方商品接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:00
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    /**
     * 模拟注入
     */
    private POPOrderService popOrderService = new POPOrderService();

    /**
     * 用户是否首单
     *
     * @param uId 用户id
     * @return boolean
     * @date 2021/7/3 11:00
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
