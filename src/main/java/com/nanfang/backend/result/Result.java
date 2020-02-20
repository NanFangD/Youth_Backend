package com.nanfang.backend.result;

/**
 * @author nanfang
 * @create 2020/01/27/15:59
 */
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

