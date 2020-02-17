package com.panici.springbootdemo.advice;

import com.panici.springbootdemo.common.ErrorResponse;
import com.panici.springbootdemo.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandleAdvice {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ErrorResponse handleException(BaseException e, HttpServletRequest request){
        return ErrorResponse.build(e.getError(),request.getRequestURI());
    }

}
