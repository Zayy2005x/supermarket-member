package com.zayy.supermarketmember.common.exception;


/**
 * 二次确认密码不一致异常
 */
public class RePasswordNotMatchException extends BaseException{
    public RePasswordNotMatchException(String msg) {
        super(msg);
    }

    public RePasswordNotMatchException() {
    }
}
