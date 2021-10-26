package com.jsjds.enums;

public enum ReturnCode {

    SUCCESS("PI200", "执行成功"),
    NODATA("PI201", "执行成功，无返回值"),
    FEAILED("PI500", "执行失败"),
    PARAMS_ERROR("PI400", "参数为空或格式错误");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}