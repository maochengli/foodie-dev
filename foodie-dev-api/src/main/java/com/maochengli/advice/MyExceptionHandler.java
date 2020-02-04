package com.maochengli.advice;

import com.maochengli.enums.ExceptionEmum;
import com.maochengli.exceptions.DescribeException;
import com.maochengli.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class MyExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionGet(Exception e){
        if(e instanceof DescribeException){
            DescribeException myException = (DescribeException) e;
            return Result.error(myException.getCode(),myException.getMessage());
        }
        LOGGER.error("【出现异常】{}",e);
        return Result.error(ExceptionEmum.UNKNOW_ERROR);
    }

}
