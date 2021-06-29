package com.base.demo.design.coat;

import com.base.demo.design.DecorateMaterialMatter;

import java.math.BigDecimal;

/**
 * @Description: 涂料--品牌：立邦
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.coat
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:39
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class LiBangCoat implements DecorateMaterialMatter {

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
        return "涂料";
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
        return "立邦";
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
        return "默认级别";
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
        return new BigDecimal(650);
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
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }

}
