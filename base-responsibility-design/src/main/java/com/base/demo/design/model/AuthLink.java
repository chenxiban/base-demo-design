package com.base.demo.design.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 审批规定
 * 1. 601-610 三级审批 + 二级审批
 * 2. 611-620 三级审批 + 二级审批 + 一级审批
 * 3. 其他时间 三级审批
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-01 17:04
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public abstract class AuthLink {

    /**
     * 时间格式化
     */
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 级别人员ID
     */
    protected String levelUserId;

    /**
     * 级别人员姓名
     */
    protected String levelUserName;

    /**
     * 责任链
     */
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
