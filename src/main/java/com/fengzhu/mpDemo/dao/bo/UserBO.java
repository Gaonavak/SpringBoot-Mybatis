package com.fengzhu.mpDemo.dao.bo;

import lombok.Data;

/**
 * 业务对象：内部业务逻辑用
 */
@Data
public class UserBO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    // 可以加一些业务处理相关的字段，比如：
    private boolean isAdult; // 根据age计算是否成年
}
