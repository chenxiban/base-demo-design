package com.base.demo.design;

import java.math.BigDecimal;

/**
 * @Description: 装修物料
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:31
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface DecorateMaterialMatter {

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    String scene();

    /**
     * 品牌
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    String brand();

    /**
     * 景；地板、地砖、涂料、吊顶
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    String model();

    /**
     * 平米报价
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    BigDecimal price();

    /**
     * 描述
     *
     * @return java.lang.String
     * @date 2021/6/29 11:32
     * @author ChenYongJia
     * @version 1.0
     */
    String desc();

}
