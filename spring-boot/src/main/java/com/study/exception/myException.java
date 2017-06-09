package com.study.exception;

/**
 * @author yk
 * @version 1.0 Date: 2017/6/8
 */
public class myException extends RuntimeException{
    private Integer code;
    private String message;

    public myException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
