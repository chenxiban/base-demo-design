package com.base.demo.design.service.impl;

import com.base.demo.design.result.LotteryResult;
import com.base.demo.design.service.LotteryService;
import com.base.demo.design.service.MinibusTargetService;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description: 实现类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.service.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:46
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class LotteryServiceImpl implements LotteryService {

    /**
     * 模拟注入
     */
    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    /**
     * 从以上的方法实现中可以看到，整体过程包括三部分；摇号、发短信、发MQ消息，而这部分都是顺序调用的。
     * <p>
     * 除了摇号接口调用外，后面的两部分都是非核心主链路功能，而且会随着后续的业务需求发展而不断的调整和扩充，在这样的开发方式下就非常不利于维护。
     *
     * @param uId 用户id
     * @return com.base.demo.design.result.LotteryResult
     * @date 2021/7/3 15:47
     * @author ChenYongJia
     * @version 1.0
     */
    public LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 发短信
        log.info("给用户 {} 发送短信通知(短信)：{}", uId, lottery);
        // 发MQ消息
        log.info("记录用户 {} 摇号结果(MQ)：{}", uId, lottery);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }


}
