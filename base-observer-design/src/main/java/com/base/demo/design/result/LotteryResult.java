package com.base.demo.design.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 返回对象
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.result
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:45
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LotteryResult {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 摇号信息
     */
    private String msg;

    /**
     * 业务时间
     */
    private Date dateTime;


}
