package com.base.demo.design.test.impl;

import com.base.demo.design.channel.AuthInfo;
import com.base.demo.design.channel.AuthLink;
import com.base.demo.design.test.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 二级负责人
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:06
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Level2AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-06-11 00:00:00");

    private Date endDate = f.parse("2020-06-20 23:59:59");

    public Level2AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    /**
     * 审核流程--先判断是否审核通过，如果没有审核通过则返回结果给调用方，引导去审核。
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
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", levelUserName);
        }

        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
