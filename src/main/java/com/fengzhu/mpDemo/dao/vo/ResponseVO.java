/**
 * @Author :Novak
 * @Description :
 * @Date: 2025/4/27 10:40
 */
package com.fengzhu.mpDemo.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private Integer code;
    private String message;
    private String status;
    private T data;

}