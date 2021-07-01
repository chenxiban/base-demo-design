package com.base.demo.design.test.impl;

import com.base.demo.design.model.AuthInfo;
import com.base.demo.design.model.AuthLink;
import com.base.demo.design.test.AuthService;

import java.util.Date;

/**
 * @Description: 一级负责人
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:05
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Level1AuthLink extends AuthLink {

    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    /**
     * 做审批
     *
     * @param uId      用户id
     * @param orderId  订单id
     * @param authDate 审核时间
     * @return com.base.demo.design.model.AuthInfo
     * @date 2021/7/1 17:07
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
