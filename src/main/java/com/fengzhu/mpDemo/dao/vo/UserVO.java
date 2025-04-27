package com.fengzhu.mpDemo.dao.vo;

import lombok.Data;

/**
 * 视图对象
 */
@Data
public class UserVO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private boolean isAdult; // 是否成年
}
