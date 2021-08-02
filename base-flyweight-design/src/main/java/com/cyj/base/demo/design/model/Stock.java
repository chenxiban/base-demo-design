package com.cyj.base.demo.design.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 货物
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:42
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    /**
     * 库存总量
     */
    private int total;

    /**
     * 库存已用
     */
    private int used;

}
