package com.fengzhu.mpDemo.exception;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {

    private final Integer code;

    public DatabaseException(String message) {
        super(message);
        this.code = 500; // 假设数据库异常的错误代码是 500
    }

    public Integer getCode() {
        return code;
    }
}
