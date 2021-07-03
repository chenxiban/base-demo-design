package com.base.demo.design.service;

import com.alibaba.fastjson.JSON;
import com.base.demo.design.mq.CreateAccount;

/**
 * @Description: 开户 MQ 消息服务类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 10:58
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class CreateAccountMqService {

    /**
     * 接收消息
     *
     * @param message 消息
     * @return void
     * @date 2021/7/3 10:57
     * @author ChenYongJia
     * @version 1.0
     */
    public void onMessage(String message) {

        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... 处理自己的业务
    }

}
