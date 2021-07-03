package com.base.demo.design.event.service.impl;

import com.base.demo.design.event.service.LotteryService;
import com.base.demo.design.result.LotteryResult;
import com.base.demo.design.service.MinibusTargetService;

import java.util.Date;

/**
 * @Description: 摇号接口实现
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:51
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    /**
     * 摇号--没有额外的辅助流程，只有核心流程的处理。
     *
     * @param uId 用户id
     * @return com.base.demo.design.result.LotteryResult
     * @date 2021/7/3 15:51
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }

}
