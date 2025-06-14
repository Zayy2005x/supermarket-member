package com.zayy.supermarketmember.common.exception;

/**
 * 账号被锁定异常
 */
public class AccountLockedException extends BaseException {
    public AccountLockedException(String msg) {
        super(msg);
    }

    public AccountLockedException() {
    }
}
