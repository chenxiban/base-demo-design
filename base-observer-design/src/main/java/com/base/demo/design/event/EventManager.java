package com.base.demo.design.event;

import com.base.demo.design.event.listener.EventListener;
import com.base.demo.design.result.LotteryResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 事件处理类
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:52
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    /**
     * 整个处理的实现上提供了三个主要方法；订阅(subscribe)、取消订阅(unsubscribe)、通知(notify)。这三个方法分别用于对监听时间的添加和使用。
     * <p>
     * 另外因为事件有不同的类型，这里使用了枚举的方式进行处理，也方便让外部在规定下使用事件，而不至于乱传信息(EventType.MQ、EventType.Message)。
     *
     * @param operations
     * @return
     * @date 2021/7/3 15:56
     * @author ChenYongJia
     * @version 1.0
     */
    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * 枚举值
     */
    public enum EventType {
        MQ, Message
    }

    /**
     * 订阅
     *
     * @param eventType 事件类型
     * @param listener  监听
     * @return void
     * @date 2021/7/3 15:56
     * @author ChenYongJia
     * @version 1.0
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     *
     * @param eventType 事件类型
     * @param listener  监听
     * @return void
     * @date 2021/7/3 15:56
     * @author ChenYongJia
     * @version 1.0
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     *
     * @param eventType 事件类型
     * @param result    结果
     * @return void
     * @date 2021/7/3 15:57
     * @author ChenYongJia
     * @version 1.0
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }

}
