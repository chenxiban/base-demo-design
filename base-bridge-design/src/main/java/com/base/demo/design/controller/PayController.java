package com.base.demo.design.controller;

import com.base.demo.design.utils.model.enums.SelectTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @Description: 支付控制器
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:11
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class PayController {

    /**
     * 执行支付操作
     *
     * @param uId         用户id
     * @param tradeId     交易id
     * @param amount      金额
     * @param channelType 渠道
     * @param modeType    模式
     * @return boolean
     * @date 2021/7/3 16:12
     * @author ChenYongJia
     * @version 1.0
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // 微信支付
        if (SelectTypeEnum.TYPE_ONE.getCode() == channelType) {
            log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (SelectTypeEnum.TYPE_ONE.getCode() == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (SelectTypeEnum.TYPE_TWO.getCode() == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (SelectTypeEnum.TYPE_THREE.getCode() == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (SelectTypeEnum.TYPE_TWO.getCode() == channelType) {
            log.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (SelectTypeEnum.TYPE_ONE.getCode() == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (SelectTypeEnum.TYPE_TWO.getCode() == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (SelectTypeEnum.TYPE_THREE.getCode() == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }

}
