package com.fengzhu.mpDemo.exception;

import com.fengzhu.mpDemo.config.enums.ResponseCodeEnum;
import com.fengzhu.mpDemo.dao.vo.ResponseVO;
import com.fengzhu.mpDemo.utils.ResponseTools;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j

@RestControllerAdvice  // 全局异常处理类，所有控制器都会使用到这个
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO<?> handleException(Exception e, HttpServletRequest request) {
        log.error("请求错误，请求地址{}。错误信息：{}", request.getRequestURI(), e.getMessage());
        ResponseVO<Object> ajaxResponse = new ResponseVO<>();

        if (e instanceof NotFoundException) {
            NotFoundException nof = (NotFoundException) e;
            ajaxResponse.setCode(nof.getCode());
            ajaxResponse.setMessage(e.getMessage());
            ajaxResponse.setStatus(ResponseTools.STATUS_ERROR);
        } else if (e instanceof BusinessException) {
            BusinessException biz = (BusinessException) e;
            ajaxResponse.setCode(biz.getCode());
            ajaxResponse.setMessage(biz.getMessage());
            ajaxResponse.setStatus(ResponseTools.STATUS_SUCCESS);
        } else if (e instanceof ValidationException) {
            ValidationException valEx = (ValidationException) e;
            ajaxResponse.setCode(valEx.getCode());
            ajaxResponse.setMessage(valEx.getMessage());
            ajaxResponse.setStatus(ResponseTools.STATUS_SUCCESS);
        } else if (e instanceof DatabaseException) {
            DatabaseException dbEx = (DatabaseException) e;
            ajaxResponse.setCode(dbEx.getCode());
            ajaxResponse.setMessage(dbEx.getMessage());
            ajaxResponse.setStatus(ResponseTools.STATUS_SUCCESS);
        } else {
            ajaxResponse.setCode(ResponseCodeEnum.CODE_500.getCode());
            ajaxResponse.setMessage("服务器内部错误");
            ajaxResponse.setStatus(ResponseTools.STATUS_SUCCESS);
        }
        return ajaxResponse;
    }
}
