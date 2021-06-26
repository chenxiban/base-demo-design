package com.base.demo.design.test;

import com.base.demo.design.Factory.StoreFactory;
import com.base.demo.design.dao.ICommodity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试工厂模式接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 15:00
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class DemoTest {

    /**
     * 测试通过工厂模式调用方法产出结果
     *
     * @return void
     * @date 2021/6/26 15:00
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();

        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);

        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        Map<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "陈小佳");
        extMap.put("consigneeUserPhone", "15638589820");
        extMap.put("consigneeUserAddress", "上海市、松江区、泗泾镇、金港花园一期119号");

        commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113", new HashMap<String, String>() {{
            put("consigneeUserName", "陈小佳");
            put("consigneeUserPhone", "15638589820");
            put("consigneeUserAddress", "上海市、松江区、泗泾镇、金港花园一期119号");
        }});

        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);

    }

}
