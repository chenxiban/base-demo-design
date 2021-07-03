package com.base.demo.design.channel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @Description: 选择题--单选题
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.model
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-02 08:52
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChoiceQuestion {

    /**
     * 题目
     */
    private String name;

    /**
     * 选项；A、B、C、D
     */
    private Map<String, String> option;

    /**
     * 答案；B
     */
    private String key;

}
