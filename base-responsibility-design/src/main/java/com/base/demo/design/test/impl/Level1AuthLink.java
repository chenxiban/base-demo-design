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
     * 做审批--先判断是否审核通过，如果没有审核通过则返回结果给调用方，引导去审核。（这里简单模拟审核后有时间信息不为空，作为判断条件）
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

        // 判断完成后获取下一个审核节点；super.next();，如果不存在下一个节点，则直接返回结果。
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        // 返回下一个审核结果；next.doAuth(uId, orderId, authDate);，有点像递归调用。
        return next.doAuth(uId, orderId, authDate);
    }

}
