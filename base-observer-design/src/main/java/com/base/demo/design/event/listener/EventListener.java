package com.base.demo.design.event.listener;

import com.base.demo.design.result.LotteryResult;

/**
 * @Description: 事件监听接口定义
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.event.listener
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 15:53
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public interface EventListener {

    /**
     * 接口中定义了基本的事件类，这里如果方法的入参信息类型是变化的可以使用泛型<T>
     *
     * @param result
     * @return void
     * @date 2021/7/3 15:53
     * @author ChenYongJia
     * @version 1.0
     */
    void doEvent(LotteryResult result);

}
