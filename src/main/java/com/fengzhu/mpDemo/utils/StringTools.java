/**
 * @Author :Novak
 * @Description :
 * @Date: 2025/4/27 14:35
 */
package com.fengzhu.mpDemo.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.DigestUtils;

public class StringTools {

    /** 判断字符串是否为空（null、空串、"null"、空格都算空） */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty() || "null".equalsIgnoreCase(str) || "\u0000".equals(str);
    }

    /** 生成指定长度的随机数字串（只包含数字） */
    public static String getRandomNumber(int count) {
        return RandomStringUtils.random(count, false, true);
    }

    /** 生成指定长度的随机字符串（字母 + 数字） */
    public static String getRandomString(int count) {
        return RandomStringUtils.random(count, true, true);
    }

    /** 对字符串进行MD5加密，返回小写32位结果 */
    public static String encodeMd5(String originString) {
        return isEmpty(originString) ? null : DigestUtils.md5DigestAsHex(originString.getBytes());
    }

    /** 把字段名首字母大写（用于反射调用getter/setter方法名） */
    public static String upperCaseFirstLetter(String field) {
        if (isEmpty(field)) {
            return field;
        }
        if (field.length() > 1 && Character.isUpperCase(field.charAt(1))) {
            return field;
        }
        return field.substring(0, 1).toUpperCase() + field.substring(1);
    }
}