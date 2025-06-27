package com.zayy.supermarketmember.handle;


import com.zayy.supermarketmember.common.constant.MessageConstant;
import com.zayy.supermarketmember.common.exception.BaseException;
import com.zayy.supermarketmember.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}",ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        if(message.contains("Duplicate entry")){
            String []split = message.split(" ");
            String username = split[2];
            String returnMessage = username + MessageConstant.ALREADY_EXIST;
            return Result.error(returnMessage);
        }else{
            return Result.error(MessageConstant.UNKNOW_ERROR);
        }
    }
}
