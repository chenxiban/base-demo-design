package com.base.demo.design.controller;

import com.base.demo.design.channel.AuthInfo;
import com.base.demo.design.test.AuthService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 审核流程控制器--审核的控制类
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

    /**
     * 这里从上到下分别判断了在指定时间范围内由不同的人员进行审批，就像618上线的时候需要三个负责人都审批才能让系统进行上线。
     * <p>
     * 像是这样的功能看起来很简单的，但是实际的业务中会有很多部门，但如果这样实现就很难进行扩展，并且在改动扩展调整也非常麻烦。
     *
     * @param uId      用户id
     * @param orderId  订单号
     * @param authDate 审核时间
     * @return com.base.demo.design.model.AuthInfo
     * @date 2021/7/3 10:04
     * @author ChenYongJia
     * @version 1.0
     */
    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {

        // 三级审批
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批，负责人 ", "王工");

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
