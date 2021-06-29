package com.base.demo.design.controller;

import com.base.demo.design.DecorateMaterialMatter;
import com.base.demo.design.ceiliang.LevelOneCeiling;
import com.base.demo.design.ceiliang.LevelTwoCeiling;
import com.base.demo.design.coat.DuluxCoat;
import com.base.demo.design.coat.LiBangCoat;
import com.base.demo.design.floor.ShengXiangFloor;
import com.base.demo.design.tile.DongPengTile;
import com.base.demo.design.tile.MarcoPoloTile;
import com.base.demo.design.utils.model.enums.SelectTypeEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 模拟调用控制器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:45
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class DecorationPackageController {

    public String getDecorateMaterialMatterList(BigDecimal area, Integer level) {

        // 装修清单
        List<DecorateMaterialMatter> list = new ArrayList<>();
        // 装修价格
        BigDecimal price = BigDecimal.ZERO;

        // 豪华欧式
        if (SelectTypeEnum.TYPE_ONE.getCode() == level) {
            // 吊顶，二级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            // 涂料，多乐士
            DuluxCoat duluxCoat = new DuluxCoat();
            // 地板，圣象
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));

        }

        // 轻奢田园
        if (SelectTypeEnum.TYPE_TWO.getCode() == level) {
            // 吊顶，二级顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            // 涂料，立邦
            LiBangCoat liBangCoat = new LiBangCoat();
            // 地砖，马可波罗
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        // 现代简约
        if (SelectTypeEnum.TYPE_THREE.getCode() == level) {
            // 吊顶，二级顶
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            // 涂料，立邦
            LiBangCoat liBangCoat = new LiBangCoat();
            // 地砖，东鹏
            DongPengTile dongPengTile = new DongPengTile();

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (DecorateMaterialMatter DecorateMaterialMatter : list) {
            detail.append(DecorateMaterialMatter.scene()).append("：").append(DecorateMaterialMatter.brand()).append("、").append(DecorateMaterialMatter.model()).append("、平米价格：").append(DecorateMaterialMatter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
