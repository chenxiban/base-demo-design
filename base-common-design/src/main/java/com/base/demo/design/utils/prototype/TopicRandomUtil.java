package com.base.demo.design.utils.prototype;

import java.util.*;

/**
 * @Description: 针对每一个试卷都会使用克隆的方式进行复制，复制完成后将试卷中题目以及每个题目的答案进行乱序处理。这里提供了工具包；TopicRandomUtil
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.utils.prototype
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-30 14:17
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class TopicRandomUtil {

    private static Integer initialCapacity = 16;

    /**
     * 乱序Map元素，记录对应答案key
     *
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     * @date 2021/6/30 14:17
     * @author ChenYongJia
     * @version 1.0
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        Map<String, String> optionNew = new HashMap<String, String>(initialCapacity);
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}
