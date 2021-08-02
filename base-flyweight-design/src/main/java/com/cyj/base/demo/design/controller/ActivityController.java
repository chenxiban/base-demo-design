package com.cyj.base.demo.design.controller;

import com.cyj.base.demo.design.model.Activity;
import com.cyj.base.demo.design.model.Stock;

import java.util.Date;

/**
 * @Description: 活动控制器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:40
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ActivityController {

    /**
     * 这里模拟的是从接口中查询活动信息，基本也就是从数据库中获取所有的商品信息和库存。有点像最开始写的商品销售系统，数据库就可以抗住购物量。
     * <p>
     * 当后续因为业务的发展需要扩展代码将库存部分交给redis处理，那么就需要从redis中获取活动的库存，而不是从库中，否则将造成数据不统一的问题。
     *
     * @param id id
     * @return Activity
     * @date 2021/8/2 10:40
     * @author ChenYongJia
     * @version 1.0
     */
    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用从接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨乐");
        activity.setDesc("图书优惠券分享激励分享活动第二期");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }

}
