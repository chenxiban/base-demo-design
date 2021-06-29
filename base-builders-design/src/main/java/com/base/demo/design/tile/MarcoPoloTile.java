package com.base.demo.design.tile;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 地砖--品牌：马可波罗（MARCO POLO）
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.tile
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class MarcoPoloTile implements DecorateMaterialMatter {

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
        return "马可波罗（MARCO POLO）";
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
        return "缺省";
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
        return new BigDecimal(140);
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
        return "“马可波罗”品牌诞生于1996年，作为国内最早品牌化的建陶品牌，以“文化陶瓷”占领市场，享有“仿古砖至尊”的美誉。";
    }

}
