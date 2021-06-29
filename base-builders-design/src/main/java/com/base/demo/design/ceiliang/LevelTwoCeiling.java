package com.base.demo.design.ceiliang;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 吊顶--品牌：装修公司自带--型号：二级顶
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.ceiliang
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:35
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class LevelTwoCeiling implements DecorateMaterialMatter {

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String scene() {
        return "吊顶";
    }

    /**
     * 品牌
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String brand() {
        return "装修公司自带";
    }

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String model() {
        return "二级顶";
    }

    /**
     * 平米报价
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    /**
     * 描述
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }

}
