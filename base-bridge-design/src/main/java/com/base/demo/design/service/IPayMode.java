package com.base.demo.design.service;

/**
 * @Description: 支付模式接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 16:25
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface IPayMode {

    /**
     * 任何一个支付模式；刷脸、指纹、密码，都会过不同程度的安全风控，这里定义一个安全校验接口。
     *
     * @param uId 用户id
     * @return boolean
     * @date 2021/7/3 16:25
     * @author ChenYongJia
     * @version 1.0
     */
    boolean security(String uId);

}
