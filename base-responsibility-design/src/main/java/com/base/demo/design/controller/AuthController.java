package com.base.demo.design.controller;

import com.base.demo.design.model.AuthInfo;
import com.base.demo.design.service.AuthService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 审核流程控制器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 16:59
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class AuthController {

    /**
     * 时间格式化
     */
    private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {

        // 三级审批
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", "王工");

        // 二级审批
        if (authDate.after(f.parse("2020-06-01 00:00:00")) && authDate.before(f.parse("2020-06-25 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000012", orderId);
            if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", "张经理");
        }

        // 一级审批
        if (authDate.after(f.parse("2020-06-11 00:00:00")) && authDate.before(f.parse("2020-06-20 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000011", orderId);
            if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", "段总");
        }

        return new AuthInfo("0001", "单号：", orderId, " 状态：审批完成");
    }

}
