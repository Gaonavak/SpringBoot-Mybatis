/**
 * @Author :Novak
 * @Description :
 * @Date: 2025/4/27 14:02
 */
package com.fengzhu.mpDemo.utils;

import com.fengzhu.mpDemo.config.enums.ResponseCodeEnum;
import com.fengzhu.mpDemo.dao.vo.ResponseVO;
import com.fengzhu.mpDemo.exception.BusinessException;

public class ResponseTools {
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_ERROR = "error";

    public <T> ResponseVO<T> getSuccessResponseVo(T t) {
        ResponseVO<T> ResponseVO = new ResponseVO<>();
        ResponseVO.setStatus(STATUS_SUCCESS);
        ResponseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        ResponseVO.setMessage(ResponseCodeEnum.CODE_200.getMsg());
        ResponseVO.setData(t);
        return ResponseVO;
    }

    protected <T> ResponseVO<T> getBusinessErrorResponseVo(BusinessException e) {
        ResponseVO<T> vo = new ResponseVO<>();
        vo.setStatus(STATUS_ERROR);
        vo.setCode((e.getCode() != null) ? e.getCode() : ResponseCodeEnum.CODE_600.getCode()); // 修正获取错误代码
        vo.setMessage(e.getMessage()); // 保持信息设置一致
        return vo;
    }

    protected <T> ResponseVO<T> getServerErrorResponseVo(T t) {
        ResponseVO<T> vo = new ResponseVO<>();
        vo.setStatus(STATUS_ERROR);
        vo.setCode(ResponseCodeEnum.CODE_500.getCode());
        vo.setMessage(ResponseCodeEnum.CODE_500.getMsg());
        vo.setData(t);
        return vo;
    }
}