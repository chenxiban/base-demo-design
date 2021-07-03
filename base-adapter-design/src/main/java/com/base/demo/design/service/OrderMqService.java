package com.base.demo.design.service;

import com.base.demo.design.mq.OrderMq;
import com.alibaba.fastjson.JSON;

/**
 * @Description: 模拟订单 MQ 消息服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:49
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class OrderMqService {

    /**
     * 接收消息
     *
     * @param message 消息
     * @return void
     * @date 2021/7/3 10:57
     * @author ChenYongJia
     * @version 1.0
     */
    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... 处理自己的业务
    }

}
