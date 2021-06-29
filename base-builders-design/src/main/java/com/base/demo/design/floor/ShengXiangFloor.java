package com.base.demo.design.floor;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 地板--品牌：圣象
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.floor
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:41
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class ShengXiangFloor implements DecorateMaterialMatter {

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
        return "地板";
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
        return "圣象";
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
        return "一级";
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
        return new BigDecimal(318);
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
        return "圣象地板是中国地板行业著名品牌。圣象地板拥有中国驰名商标、中国名牌、国家免检、中国环境标志认证等多项荣誉。";
    }

}
