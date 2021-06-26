package com.base.demo.design.card;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 模拟爱奇艺会员卡服务
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.card
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 10:31
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class IQiYiCardService {

    /**
     * 授权token
     * 
     * @param bindMobileNumber 绑定的手机号码
     * @param cardId 卡片id
     * @return void
     * @date 2021/6/26 10:32
     * @author ChenYongJia
     * @version 1.0
     */
    public void grantToken(String bindMobileNumber, String cardId) {
        log.info("模拟发放爱奇艺会员卡一张：{}，{}", bindMobileNumber, cardId);
    }

}
