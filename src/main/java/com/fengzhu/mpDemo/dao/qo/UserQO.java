package com.fengzhu.mpDemo.dao.qo;

import lombok.Data;

/**
 * 查询对象：用于封装查询条件
 */
@Data
public class UserQO {
    private String nameLike;   // 名字模糊匹配
    private Integer minAge;    // 年龄下限
    private Integer maxAge;    // 年龄上限
    private Integer pageNum = 1; // 页码，默认1
    private Integer pageSize = 10; // 每页大小，默认10
}
