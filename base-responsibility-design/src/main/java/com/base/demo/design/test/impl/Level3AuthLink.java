package com.base.demo.design.test.impl;

import com.base.demo.design.model.AuthInfo;
import com.base.demo.design.model.AuthLink;
import com.base.demo.design.test.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 三级负责人
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:06
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class Level3AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-06-01 00:00:00");

    private Date endDate = f.parse("2020-06-25 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    /**
     * 审核流程--先判断是否审核通过，如果没有审核通过则返回结果给调用方，引导去审核。
     *
     * @param uId      用户id
     * @param orderId  订单id
     * @param authDate 审核时间
     * @return com.base.demo.design.model.AuthInfo
     * @date 2021/7/1 17:08
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批，负责人 ", levelUserName);
        }

        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
