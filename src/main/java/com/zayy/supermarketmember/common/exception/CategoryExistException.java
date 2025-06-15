package com.zayy.supermarketmember.common.exception;

/**
 * 分类已存在异常
 */
public class CategoryExistException extends BaseException{
    public CategoryExistException() {

    }

    public CategoryExistException(String msg) {
        super(msg);
    }
}
