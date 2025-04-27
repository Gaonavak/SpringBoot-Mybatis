/**
 * @Author : Novak
 * @Description : 工具类，用于对象复制
 * @Date: 2025/4/24 19:34
 */
package com.fengzhu.mpDemo.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyTools {

    // 复制列表中的对象
    public static <T, S> List<S> copyList(List<T> tList, Class<S> sClass) {
        List<S> list = new ArrayList<>();
        for (T t : tList) {
            try {
                S s = sClass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(t, s); // 使用 Spring 的 BeanUtils 复制属性
                list.add(s);
            } catch (Exception e) {
                e.printStackTrace(); // 可以考虑更好的异常处理
            }
        }
        return list;
    }

    // 复制单个对象
    public static <T, S> T copy(S s, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(s, t); // 使用 Spring 的 BeanUtils 复制属性
        } catch (Exception e) {
            e.printStackTrace(); // 可以考虑更好的异常处理
        }
        return t;
    }
}