package com.cyj.base.demo.design.controller;

import com.cyj.base.demo.design.ActivityFactory;
import com.cyj.base.demo.design.model.Activity;
import com.cyj.base.demo.design.model.Stock;
import com.cyj.base.demo.design.util.RedisUtils;

/**
 * @Description:
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:45
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ActivityController2 {

    private RedisUtils redisUtils = new RedisUtils();

    /**
     * 在活动控制类中使用了享元工厂获取活动信息，查询后将库存信息在补充上。因为库存信息是变化的，而活动信息是固定不变的。
     * <p>
     * 最终通过统一的控制类就可以把完整包装后的活动信息返回给调用方。
     * <p>
     * 查询活动详细信息
     *
     * @param id
     * @return com.cyj.base.demo.design.model.Activity
     * @date 2021/8/2 10:46
     * @author ChenYongJia
     * @version 1.0
     */
    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
