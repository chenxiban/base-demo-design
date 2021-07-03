package com.base.demo.design.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 开户
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.mq
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:52
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAccount {

    /**
     * 开户编号
     */
    private String number;

    /**
     * 开户地
     */
    private String address;

    /**
     * 开户时间
     */
    private Date accountDate;

    /**
     * 开户描述
     */
    private String desc;

}
