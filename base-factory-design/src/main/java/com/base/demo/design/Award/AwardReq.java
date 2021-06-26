package com.base.demo.design.Award;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @Description: 奖品入参
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.Award
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:42
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AwardReq {

    /**
     * 用户唯一ID
     */
    private String uId;

    /**
     * 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
     */
    private Integer awardType;

    /**
     * 奖品编号；sku、couponNumber、cardId
     */
    private String awardNumber;

    /**
     * 业务ID，防重复
     */
    private String bizId;

    /**
     * 扩展信息
     */
    private Map<String, String> extMap;

}
