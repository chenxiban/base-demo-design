package com.cyj.base.demo.design.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 活动实体类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:41
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity {

    /**
     * 活动ID
     */
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动描述
     */
    private String desc;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date stopTime;

    /**
     * 活动库存
     */
    private Stock stock;

}
