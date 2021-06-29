package com.base.demo.design.floor;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 地板--品牌：德尔（der）
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.floor
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:40
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class DerFloor implements DecorateMaterialMatter {

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:46
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String scene() {
        return "地板";
    }

    /**
     * 品牌
     *
     * @return java.lang.String
     * @date 2021-6-29 11:46
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String brand() {
        return "德尔（der）";
    }

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:46
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String model() {
        return "A+";
    }

    /**
     * 平米报价
     *
     * @return java.lang.String
     * @date 2021-6-29 11:46
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    /**
     * 描述
     *
     * @return java.lang.String
     * @date 2021-6-29 11:46
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String desc() {
        return "DER德尔集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
    }

}
