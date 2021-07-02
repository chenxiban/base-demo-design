package com.base.demo.design.utils.model.enums;

import com.base.demo.design.utils.IsEmptyUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 选择类型范围0-5
 * @BelongsProject: base-demo-design
 * @BelongsPackage: com.base.demo.design.utils.model.enums
 * @Author: ChenYongJia
 * @CreateTime: 2021-06-29 11:51
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum SelectTypeEnum {

    /**
     * 枚举值
     */
    TYPE_NULL(null, "为空"),
    TYPE_ZERO(0, "选择0"),
    TYPE_ONE(1, "选择1"),
    TYPE_TWO(2, "选择2"),
    TYPE_THREE(3, "选择3"),
    TYPE_FOUR(4, "选择4"),
    TYPE_FIVE(5, "选择5"),
    ;

    private Integer code;
    private String message;

    /**
     * 根据 类型编码 来获取 描述信息
     *
     * @param code
     * @return
     */
    public static String getMessByCode(Integer code) {
        if (IsEmptyUtils.isEmpty(code)) {
            return null;
        }

        for (SelectTypeEnum userEnum : values()) {
            if (userEnum.getCode().equals(code)) {
                return userEnum.getMessage();
            }
        }
        throw new RuntimeException("没有找到对应的描述信息");
    }

    /**
     * 根据 描述信息 来获取 类型编码
     *
     * @param message
     * @return
     */
    public static Integer getCodeByMess(String message) {
        if (IsEmptyUtils.isEmpty(message)) {
            return null;
        }

        for (SelectTypeEnum userEnum : values()) {
            if (userEnum.getCode().equals(message)) {
                return userEnum.getCode();
            }
        }
        throw new RuntimeException("没有找到对应的描述信息");
    }

    public static void main(String[] args) {
        System.out.println(SelectTypeEnum.TYPE_ONE);
    }

}
