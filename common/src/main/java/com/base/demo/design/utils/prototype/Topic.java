package com.base.demo.design.utils.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @Description: 题目内容
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.utils.prototype
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-30 14:13
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topic {

    /**
     * 选项；A、B、C、D
     */
    private Map<String, String> option;

    /**
     * 答案；B
     */
    private String key;

}
