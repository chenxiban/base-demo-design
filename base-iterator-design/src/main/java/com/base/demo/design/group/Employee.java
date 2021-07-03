package com.base.demo.design.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 雇员实体
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.group
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    /**
     * 雇员id
     */
    private String uId;

    /**
     * 雇员姓名
     */
    private String name;

    /**
     * 雇员备注
     */
    private String desc;

}
