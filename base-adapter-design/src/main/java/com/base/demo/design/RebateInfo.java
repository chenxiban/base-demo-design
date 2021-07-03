package com.base.demo.design;

import java.util.Date;

/**
 * @Description: 统一的MQ消息体--MQ消息中会有多种多样的类型属性，虽然他们都有同样的值提供给使用方，但是如果都这样接入那么当MQ消息特别多时候就会很麻烦。
 * 所以在这个案例中我们定义了通用的MQ消息体，后续把所有接入进来的消息进行统一的处理。
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 11:10
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class RebateInfo {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务时间
     */
    private Date bizTime;

    /**
     * 业务描述
     */
    private String desc;

}
