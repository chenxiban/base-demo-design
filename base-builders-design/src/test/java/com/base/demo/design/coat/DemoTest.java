package com.base.demo.design.coat;

import com.base.demo.design.builder.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试传统方式的业务实现
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.desgin.coat
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-26 16:33
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class DemoTest {

    /**
     * 测试一发
     *
     * @return void
     * @date 2021/6/30 9:41
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_Builder() {
        Builder builder = new Builder();
        // 豪华欧式
        log.info(builder.levelOne(132.52D).getDetail());
        // 轻奢田园
        log.info(builder.levelTwo(98.25D).getDetail());
        // 现代简约
        log.info(builder.levelThree(85.43D).getDetail());
    }

}
