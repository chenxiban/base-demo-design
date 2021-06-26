package com.base.demo.design.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 优惠券返回结果类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.coupon
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:34
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponResult {

    /**
     * 编码信息
     */
    private String code;

    /**
     * 描述信息
     */
    private String info;

}
