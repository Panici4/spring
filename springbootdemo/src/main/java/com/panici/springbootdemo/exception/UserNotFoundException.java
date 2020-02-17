package com.panici.springbootdemo.exception;

import com.panici.springbootdemo.common.ErrorEnum;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
        super(ErrorEnum.USER_NOT_FOUND_ERROR);
    }
}
