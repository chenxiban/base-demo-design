package com.base.demo.design.tile;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 地砖--品牌：东鹏瓷砖
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.tile
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:42
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class DongPengTile implements DecorateMaterialMatter {

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:42
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String scene() {
        return "地砖";
    }

    /**
     * 品牌
     *
     * @return java.lang.String
     * @date 2021-6-29 11:42
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String brand() {
        return "东鹏瓷砖";
    }

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:42
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String model() {
        return "10001";
    }

    /**
     * 平米报价
     *
     * @return java.lang.String
     * @date 2021-6-29 11:42
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(102);
    }

    /**
     * 描述
     *
     * @return java.lang.String
     * @date 2021-6-29 11:42
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }

}
