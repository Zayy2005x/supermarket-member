package com.zayy.supermarketmember.common.exception;

/**
 * 商品分类删除异常
 */
public class CategoryDeleteException extends BaseException{
    public CategoryDeleteException() {
    }

    public CategoryDeleteException(String msg) {
        super(msg);
    }
}
