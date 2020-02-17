package com.panici.springbootdemo.common;

/**
 * 错误类型枚举
 */
public enum ErrorEnum {

    USER_NOT_FOUND_ERROR(1000,"用户不存在");

    ErrorEnum(int code, String message){
        this.code = code;
        this.message =message;
    }
    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
