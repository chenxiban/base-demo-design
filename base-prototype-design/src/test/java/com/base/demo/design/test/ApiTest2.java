package com.base.demo.design.test;

import com.base.demo.design.controller.QuestionBankController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description: 测试类--原型模式下的测试
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.test
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-02 09:01
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
public class ApiTest2 {

    /**
     * 我们通过junit单元测试的方式验证接口服务，强调日常编写好单测可以更好的提高系统的健壮度。
     *
     * 测试一把梭形式下的代码Api
     *
     * @return void
     * @date 2021/7/3 8:48
     * @author ChenYongJia
     * @version 1.0
     */
    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        log.info(questionBankController.createPaper("花花", "1000001921032"));
        log.info(questionBankController.createPaper("豆豆", "1000001921051"));
        log.info(questionBankController.createPaper("大宝", "1000001921987"));
    }

}
