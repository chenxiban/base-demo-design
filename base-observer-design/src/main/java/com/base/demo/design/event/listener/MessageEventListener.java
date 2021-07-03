package com.base.demo.design.event.listener;

import com.base.demo.design.result.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 两个监听事件的实现
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event.listener
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:54
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class MessageEventListener implements EventListener {

    /**
     * 监听事件实现
     *
     * @param result
     * @return void
     * @date 2021/7/3 15:54
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void doEvent(LotteryResult result) {
        log.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
    }

}
