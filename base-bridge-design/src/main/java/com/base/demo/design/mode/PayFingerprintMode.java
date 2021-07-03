package com.base.demo.design.mode;

import com.base.demo.design.service.IPayMode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 指纹支付
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.mode
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:27
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class PayFingerprintMode implements IPayMode {

    /**
     * 风控
     *
     * @param uId 用户id
     * @return boolean
     * @date 2021/7/3 16:27
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验环境安全");
        return true;
    }

}
