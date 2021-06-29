package com.base.demo.design.coat;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 涂料--品牌：多乐士(Dulux)
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.coat
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:37
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class DuluxCoat implements DecorateMaterialMatter {

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:38
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String scene() {
        return "涂料";
    }

    /**
     * 品牌
     *
     * @return java.lang.String
     * @date 2021-6-29 11:38
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String brand() {
        return "多乐士(Dulux)";
    }

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021-6-29 11:38
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String model() {
        return "第二代";
    }

    /**
     * 平米报价
     *
     * @return java.lang.String
     * @date 2021-6-29 11:38
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    /**
     * 描述
     *
     * @return java.lang.String
     * @date 2021-6-29 11:38
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使用多乐士油漆。";
    }

}
