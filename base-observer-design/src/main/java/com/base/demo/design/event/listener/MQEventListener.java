package com.base.demo.design.event.listener;

import com.base.demo.design.result.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: MQ发送事件
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event.listener
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:54
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class MQEventListener implements EventListener {

    /**
     * 事件的具体实现，相对来说都比较简单。如果是实际的业务开发那么会需要调用外部接口以及控制异常的处理。
     *
     * 同时我们对事件接口添加泛型，如果有需要那么在事件的实现中就可以按照不同的类型进行包装事件内容。
     *
     * @param result
     * @return void
     * @date 2021/7/3 15:55
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public void doEvent(LotteryResult result) {
        log.info("记录用户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMsg());
    }

}
