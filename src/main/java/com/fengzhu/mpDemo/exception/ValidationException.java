package com.fengzhu.mpDemo.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final Integer code;

    public ValidationException(String message) {
        super(message);
        this.code = 400; // 假设验证错误的错误代码是 400
    }

    public Integer getCode() {
        return code;
    }
}

