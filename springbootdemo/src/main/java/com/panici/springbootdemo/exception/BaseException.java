package com.panici.springbootdemo.exception;

import com.panici.springbootdemo.common.ErrorEnum;

public abstract class BaseException extends RuntimeException {

    private ErrorEnum error;

    public BaseException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }
}
