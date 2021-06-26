package com.base.demo.design.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 交付请求
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.goods
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:37
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliverReq {

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 商品SKU
     */
    private String sku;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 收货人姓名
     */
    private String consigneeUserName;

    /**
     * 收货人手机
     */
    private String consigneeUserPhone;

    /**
     * 收获人地址
     */
    private String consigneeUserAddress;

}
