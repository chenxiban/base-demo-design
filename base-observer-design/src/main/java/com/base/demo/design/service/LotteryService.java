package com.base.demo.design.service;

import com.base.demo.design.result.LotteryResult;

/**
 * @Description: 定义接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:46
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface LotteryService {

    /**
     *
     *
     * @param uId 用户id
     * @return com.base.demo.design.result.LotteryResult
     * @date 2021/7/3 15:46
     * @author ChenYongJia
     * @version 1.0
     */
    LotteryResult doDraw(String uId);

}
