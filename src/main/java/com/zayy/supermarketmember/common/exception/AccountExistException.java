package com.zayy.supermarketmember.common.exception;


/**
 * 账号已经存在异常
 */
public class AccountExistException extends BaseException{
    public AccountExistException() {
    }

    public AccountExistException(String msg) {
        super(msg);
    }
}
