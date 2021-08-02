package com.cyj.base.demo.design.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: Redis 帮助类--模拟 Redis
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.cyj.base.demo.design.util
 * @Author: ChenYongJia
 * @CreateTime: 2021-08-02 10:44
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class RedisUtils {

    /**
     * 这里处理模拟redis的操作工具类外，还提供了一个定时任务用于模拟库存的使用，这样方面我们在测试的时候可以观察到库存的变化。
     */
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 100000, TimeUnit.MICROSECONDS);

    }

    public int getStockUsed() {
        return stock.get();
    }

}
