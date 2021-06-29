package com.base.demo.design;

/**
 * @Description: 物料选择菜单
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:55
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface IMenu {

    /**
     * 吊顶
     *
     * @param matter 物料对象
     * @return com.base.demo.design.IMenu
     * @date 2021/6/29 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    IMenu appendCeiling(DecorateMaterialMatter matter);

    /**
     * 涂料
     *
     * @param matter 物料对象
     * @return com.base.demo.design.IMenu
     * @date 2021/6/29 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    IMenu appendCoat(DecorateMaterialMatter matter);

    /**
     * 地板
     *
     * @param matter 物料对象
     * @return com.base.demo.design.IMenu
     * @date 2021/6/29 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    IMenu appendFloor(DecorateMaterialMatter matter);

    /**
     * 地砖
     *
     * @param matter 物料对象
     * @return com.base.demo.design.IMenu
     * @date 2021/6/29 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    IMenu appendTile(DecorateMaterialMatter matter);

    /**
     * 明细
     *
     * @return com.base.demo.design.IMenu
     * @date 2021/6/29 11:55
     * @author ChenYongJia
     * @version 1.0
     */
    String getDetail();


}
