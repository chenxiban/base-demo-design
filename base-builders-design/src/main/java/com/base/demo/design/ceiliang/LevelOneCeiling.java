package com.base.demo.design.ceiliang;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 吊顶--品牌：装修公司自带--型号：一级顶
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.ceiliang
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:33
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class LevelOneCeiling implements DecorateMaterialMatter {

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
        return "一级顶";
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
        return new BigDecimal(260);
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
        return "造型只做低一级，只有一个层次的吊顶，一般离顶120-150mm";
    }

}
