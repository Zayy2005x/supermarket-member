package com.zayy.supermarketmember.common.exception;

import com.fasterxml.jackson.databind.ser.Serializers;

/**
 * 密码错误异常
 */
public class PasswordWrongException extends BaseException {
    public PasswordWrongException() {
    }

    public PasswordWrongException(String msg) {
        super(msg);
    }
}
