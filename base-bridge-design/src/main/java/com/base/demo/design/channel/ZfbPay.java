package com.base.demo.design.channel;

import com.base.demo.design.service.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @Description: 支付宝支付
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:23
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ZfbPay extends Pay {

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    /**
     * 划账--可以看到在支付的时候分别都调用了风控的接口进行验证，也就是不同模式的支付(刷脸、指纹)，都需要过指定的风控，才能保证支付安全。
     *
     * @param uId
     * @param tradeId
     * @param amount
     * @return java.lang.String
     * @date 2021/7/3 16:24
     * @author ChenYongJia
     * @version 1.0
     */
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟支付宝渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟支付宝渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟支付宝渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }

}
