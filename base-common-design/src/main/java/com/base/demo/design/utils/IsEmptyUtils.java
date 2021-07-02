package com.base.demo.design.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Description: 校验对象是否为空的工具类
 * @BelongsProject: fckj-restaurant
 * @BelongsPackage: com.fckj.fckjrestaurant.util.wuyexunjianutil
 * @Author: ChenYongJia
 * @CreateTime: 2021-4-1 09:31:22
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
public class IsEmptyUtils {

    /**
     * To string string.
     *
     * @param object the object
     * @return the string
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    /**
     * Is empty boolean.
     *
     * @param collection the collection
     * @return the boolean
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Is empty boolean.
     *
     * @param map the map
     * @return the boolean
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * Is empty boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isEmpty(String string) {
        return toString(string).isEmpty();
    }

    /**
     * Is empty trim boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isEmptyTrim(String string) {
        return toString(string).trim().isEmpty();
    }

    /**
     * Is empty boolean.
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isEmpty(Object object) {
        return toString(object).isEmpty();
    }

    /**
     * Is empty trim boolean.
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isEmptyTrim(Object object) {
        return toString(object).trim().isEmpty();
    }

    /**
     * Is empty boolean.
     *
     * @param <T>   the type parameter
     * @param array the array
     * @return the boolean
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

}
