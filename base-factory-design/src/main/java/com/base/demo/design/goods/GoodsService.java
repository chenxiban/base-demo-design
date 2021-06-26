package com.base.demo.design.goods;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 模拟实物商品服务
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.goods
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:39
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class GoodsService {

    /**
     * 模拟发货实物商品
     *
     * @param req 交付请求实体
     * @return java.lang.Boolean
     * @date 2021/6/26 10:40
     * @author ChenYongJia
     * @version 1.0
     */
    public Boolean deliverGoods(DeliverReq req) {
        log.info("模拟发货实物商品一个：{}", JSON.toJSONString(req));
        return true;
    }

}
