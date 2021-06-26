package com.base.demo.design.Factory;

import com.base.demo.design.dao.ICommodity;
import com.base.demo.design.impl.CardCommodityService;
import com.base.demo.design.impl.CouponCommodityService;
import com.base.demo.design.impl.GoodsCommodityService;
import com.base.demo.design.model.CommodityTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 存储调用工厂类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.Factory
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 11:03
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class StoreFactory {

    /**
     * 通过工厂模式调用不同的service
     *
     * @param commodityType 奖励类型
     * @return com.base.demo.design.dao.ICommodity
     * @date 2021/6/26 11:35
     * @author ChenYongJia
     * @version 1.0
     */
    public ICommodity getCommodityService(Integer commodityType) {

        if (CommodityTypeEnum.TYPE_ONE.getCode().equals(commodityType)) {
            return new CouponCommodityService();
        } else if (CommodityTypeEnum.TYPE_TWO.getCode().equals(commodityType)) {
            return new GoodsCommodityService();
        } else if (CommodityTypeEnum.TYPE_THREE.getCode().equals(commodityType)) {
            return new CardCommodityService();
        } else if (CommodityTypeEnum.TYPE_NULL.getCode().equals(commodityType)) {
            return null;
        }
        log.error("不存在的商品服务类型");
        throw new RuntimeException("不存在的商品服务类型");
    }


}
