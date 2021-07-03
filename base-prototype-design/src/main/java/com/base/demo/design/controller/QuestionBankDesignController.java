package com.base.demo.design.controller;

import com.base.demo.design.impl.QuestionBank;
import com.base.demo.design.model.AnswerQuestion;
import com.base.demo.design.model.ChoiceQuestion;
import com.base.demo.design.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 题库控制器2
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.controller
 * @Author: ChenYongJia
 * @CreateTime: 2021-07-03 09:27
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class QuestionBankDesignController {

    private QuestionBank questionBank = new QuestionBank();

    public void QuestionBankController() {

        Map<String, String> map01 = new HashMap<>(Constant.INITIAL_CAPACITY);
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");

        Map<String, String> map02 = new HashMap<>(Constant.INITIAL_CAPACITY);
        map02.put("A", "JAVA程序的main方法必须写在类里面");
        map02.put("B", "JAVA程序中可以有多个main方法");
        map02.put("C", "JAVA程序中类名必须与文件名一样");
        map02.put("D", "JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来");

        Map<String, String> map03 = new HashMap<>(Constant.INITIAL_CAPACITY);
        map03.put("A", "变量由字母、下划线、数字、$符号随意组成；");
        map03.put("B", "变量不能以数字作为开头；");
        map03.put("C", "A和a在java中是同一个变量；");
        map03.put("D", "不同类型的变量，可以起相同的名字；");

        Map<String, String> map04 = new HashMap<>(Constant.INITIAL_CAPACITY);
        map04.put("A", "STRING");
        map04.put("B", "x3x;");
        map04.put("C", "void");
        map04.put("D", "de$f");

        Map<String, String> map05 = new HashMap<>(Constant.INITIAL_CAPACITY);
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        questionBank.append(new ChoiceQuestion("JAVA所定义的版本中不包括", map01, "D"))
                .append(new ChoiceQuestion("下列说法正确的是", map02, "A"))
                .append(new ChoiceQuestion("变量命名规范说法正确的是", map03, "B"))
                .append(new ChoiceQuestion("以下()不是合法的标识符", map04, "C"))
                .append(new ChoiceQuestion("表达式(11+3*8)/4%3的值是", map05, "D"))
                .append(new AnswerQuestion("小红马和小黑马生的小马几条腿", "4条腿"))
                .append(new AnswerQuestion("铁棒打头疼还是木棒打头疼", "头最疼"))
                .append(new AnswerQuestion("什么床不能睡觉", "牙床"))
                .append(new AnswerQuestion("为什么好马不吃回头草", "后面的草没了"));
    }

    /**
     * 这个类的内容就比较简单了，主要提供对试卷内容的模式初始化操作(所有考生试卷一样，题目顺序不一致)。
     * <p>
     * 以及对外部提供创建试卷的方法，在创建的过程中使用的是克隆的方式；(QuestionBank) questionBank.clone();，并最终返回试卷信息。
     *
     * @param candidate 考生
     * @param number    考号
     * @return java.lang.String
     * @date 2021/7/3 9:28
     * @author ChenYongJia
     * @version 1.0
     */
    public String createPaper(String candidate, String number) throws CloneNotSupportedException {
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);
        return questionBankClone.toString();
    }

}
