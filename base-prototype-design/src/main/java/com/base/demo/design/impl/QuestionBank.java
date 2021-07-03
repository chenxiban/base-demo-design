package com.base.demo.design.impl;

import com.base.demo.design.channel.AnswerQuestion;
import com.base.demo.design.channel.ChoiceQuestion;
import com.base.demo.design.utils.prototype.Topic;
import com.base.demo.design.utils.prototype.TopicRandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @Description: 题库实现类--主要负责将各个的题目进行组装最终输出试卷。
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.impl
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-02 08:59
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class QuestionBank implements Cloneable {

    /**
     * 考生
     */
    private String candidate;

    /**
     * 考号
     */
    private String number;

    /**
     * 选择题集合
     */
    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();

    /**
     * 问答题集合
     */
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    /**
     * 封装添加方法--两个append()，对各项题目的添加，有点像我们在建造者模式中使用的方式，添加装修物料
     *
     * @param choiceQuestion 选择题对象
     * @return com.base.demo.design.impl.QuestionBank
     * @date 2021/7/3 8:59
     * @author ChenYongJia
     * @version 1.0
     */
    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        choiceQuestionList.add(choiceQuestion);
        return this;
    }

    /**
     * 封装添加方法--两个append()，对各项题目的添加，有点像我们在建造者模式中使用的方式，添加装修物料
     *
     * @param answerQuestion 问答题对象
     * @return com.base.demo.design.impl.QuestionBank
     * @date 2021/7/3 8:59
     * @author ChenYongJia
     * @version 1.0
     */
    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestionList.add(answerQuestion);
        return this;
    }

    /**
     * 克隆方法--clone() ，这里的核心操作就是对对象的复制，这里的复制不只是包括了本身，同时对两个集合也做了复制。
     * 只有这样的拷贝才能确保在操作克隆对象的时候不影响原对象。
     *
     * @return java.lang.Object
     * @date 2021/7/3 8:59
     * @author ChenYongJia
     * @version 1.0
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        /**
         *
         * clone顾名思义就是复制， 在Java语言中， clone方法被对象调用，所以会复制对象。
         * 所谓的复制对象，首先要分配一个和源对象同样大小的空间，在这个空间中创建一个新的对象。
         *
         * 有几种方式可以创建对象呢？
         * 1 使用new操作符创建一个对象
         * 2 使用clone方法复制一个对象
         * https://blog.csdn.net/zhangjg_blog/article/details/18369201--Java中的clone方法 -- 原型模式
         */
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        // 题目乱序--Collections.shuffle()的作用是对集合进行重新打乱(随机排序)。
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        // 答案乱序
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());
        }
        return questionBank;
    }

    /**
     * 设置考生
     *
     * @param candidate 考生
     * @return void
     * @date 2021/7/3 9:15
     * @author ChenYongJia
     * @version 1.0
     */
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    /**
     * 设置考号
     *
     * @param number 考号
     * @return void
     * @date 2021/7/3 9:15
     * @author ChenYongJia
     * @version 1.0
     */
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {

        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestionList.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");
                ;
            }
            detail.append("答案：").append(choiceQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestionList.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        return detail.toString();
    }

}
