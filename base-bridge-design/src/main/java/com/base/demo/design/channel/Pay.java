package com.base.demo.design.channel;

import com.base.demo.design.service.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @Description: 支付类型桥接抽象类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:22
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public abstract class Pay {

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 划账
     * <p>
     * 在这个类中定义了支付方式的需要实现的划账接口：transfer，以及桥接接口；IPayMode，并在构造函数中用户方自行选择支付方式。
     * <p>
     * 如果没有接触过此类实现，可以重点关注 IPayMode payMode，这部分是桥接的核心。
     *
     * @param uId
     * @param tradeId
     * @param amount
     * @return java.lang.String
     * @date 2021/7/3 16:23
     * @author ChenYongJia
     * @version 1.0
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
