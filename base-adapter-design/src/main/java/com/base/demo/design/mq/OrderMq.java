package com.base.demo.design.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 内部订单 MQ 消息队列
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.mq
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:50
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderMq {

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 商品
     */
    private String sku;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 下单时间
     */
    private Date createOrderTime;

}
