package com.zayy.supermarketmember.common.exception;

/**
 * 账号不存在异常
 */
public class AccountNotExistException extends BaseException {
    public AccountNotExistException(String message) {
        super(message);
    }

    public AccountNotExistException() {
    }
}
