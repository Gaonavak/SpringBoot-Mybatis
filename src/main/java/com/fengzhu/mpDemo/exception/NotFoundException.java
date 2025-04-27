package com.fengzhu.mpDemo.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final Integer code;

    public NotFoundException(String message) {
        super(message);
        this.code = 404;
    }

    public Integer getCode() {
        return code;
    }
}
