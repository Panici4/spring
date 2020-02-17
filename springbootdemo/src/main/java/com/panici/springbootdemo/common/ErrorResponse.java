package com.panici.springbootdemo.common;

import java.time.LocalDateTime;

/**
 * 错误信息相应类
 */
public class ErrorResponse {

    private int code;

    private String message;

    private LocalDateTime timestamp;

    private String path;

    public ErrorResponse() {
    }

    public static ErrorResponse build(ErrorEnum errorEnum,String path){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorEnum.getCode());
        errorResponse.setMessage(errorEnum.getMessage());
        errorResponse.setPath(path);
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
