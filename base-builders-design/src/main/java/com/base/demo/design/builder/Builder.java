package com.base.demo.design.builder;

import com.base.demo.design.IMenu;
import com.base.demo.design.ceiliang.LevelOneCeiling;
import com.base.demo.design.ceiliang.LevelTwoCeiling;
import com.base.demo.design.coat.DuluxCoat;
import com.base.demo.design.coat.LiBangCoat;
import com.base.demo.design.floor.ShengXiangFloor;
import com.base.demo.design.packagemenu.DecorationPackageMenu;
import com.base.demo.design.tile.DongPengTile;
import com.base.demo.design.tile.MarcoPoloTile;

/**
 * @Description: 建造器模式
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.builder
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:54
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，多乐士
                .appendCoat(new DuluxCoat())
                // 地板，圣象
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                // 吊顶，二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，马可波罗
                .appendTile(new MarcoPoloTile());
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                // 吊顶，二级顶
                .appendCeiling(new LevelOneCeiling())
                // 涂料，立邦
                .appendCoat(new LiBangCoat())
                // 地砖，东鹏
                .appendTile(new DongPengTile());
    }

}
