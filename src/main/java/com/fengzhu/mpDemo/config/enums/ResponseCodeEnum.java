/**
 * @Author :Novak
 * @Description :
 * @Date: 2025/4/27 14:06
 */
package com.fengzhu.mpDemo.config.enums;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    CODE_200(200, "成功"),
    CODE_400(400, "请求错误"),
    CODE_404(404, "未找到请求的资源"),
    CODE_500(500, "服务器内部错误"),
    CODE_600(600, "业务错误"),
    CODE_601(601, "主键冲突");

    private final Integer code;
    private final String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}