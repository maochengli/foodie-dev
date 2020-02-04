package com.maochengli.enums;


/**
 * 系统异常枚举类
 */
public enum ExceptionEmum {

    UNKNOW_ERROR(-1,"未知异常"),
    User_NOT_FIND(-101,"用户未找到"),
    COMMON_ERROR(-1,"系统异常，请稍后重试");

    private Integer code;

    private String msg;


    ExceptionEmum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
