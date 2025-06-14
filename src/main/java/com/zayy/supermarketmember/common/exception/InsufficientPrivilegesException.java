package com.zayy.supermarketmember.common.exception;


/**
 * 权限不足异常
 */
public class InsufficientPrivilegesException extends BaseException{

    public InsufficientPrivilegesException(String msg) {
        super(msg);
    }

    public InsufficientPrivilegesException() {
    }
}
