package com.base.demo.design.service;

/**
 * @Description: 摇号服务接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class MinibusTargetService {

    /**
     * 模拟摇号，但不是摇号算法
     *
     * @param uId 用户编号
     * @return 结果
     * @date 2021/7/3 15:44
     * @author ChenYongJia
     * @version 1.0
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(uId).concat("在本次摇号中签") : "很遗憾，编码"
                .concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }

}
