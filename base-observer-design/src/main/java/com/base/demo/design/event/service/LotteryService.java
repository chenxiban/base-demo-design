package com.base.demo.design.event.service;

import com.base.demo.design.event.EventManager;
import com.base.demo.design.event.listener.MQEventListener;
import com.base.demo.design.event.listener.MessageEventListener;
import com.base.demo.design.result.LotteryResult;

/**
 * @Description: 摇号接口
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event.service
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:50
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public abstract class LotteryService {

    private EventManager eventManager;

    /**
     * 这种使用抽象类的方式定义实现方法，可以在方法中扩展需要的额外调用。并提供抽象类abstract LotteryResult doDraw(String uId)，让类的继承者实现。
     * <p>
     * 同时方法的定义使用的是protected，也就是保证将来外部的调用方不会调用到此方法，只有调用到draw(String uId)，才能让我们完成事件通知。
     * <p>
     * 此种方式的实现就是在抽象类中写好一个基本的方法，在方法中完成新增逻辑的同时，再增加抽象类的使用。而这个抽象类的定义会有继承者实现。
     * <p>
     * 另外在构造函数中提供了对事件的定义；eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener())。
     * <p>
     * 在使用的时候也是使用枚举的方式进行通知使用，传了什么类型EventManager.EventType.MQ，就会执行什么事件通知，按需添加。
     *
     * @return
     * @date 2021/7/3 15:57
     * @author ChenYongJia
     * @version 1.0
     */
    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);

}
