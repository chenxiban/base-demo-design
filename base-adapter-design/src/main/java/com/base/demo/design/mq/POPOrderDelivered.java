package com.base.demo.design.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 第三方订单--订单妥投
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.mq
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:53
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class POPOrderDelivered {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 商品
     */
    private Date sku;

    /**
     * 商品名称
     */
    private Date skuName;

    /**
     * 金额
     */
    private BigDecimal decimal;

}
