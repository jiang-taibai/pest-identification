package com.jsjds.utils;

import com.jsjds.enums.ReturnCode;
import lombok.Data;

@Data
public class ResponseWrapper {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;


    /**
     * 自定义返回结果
     * 建议使用统一的返回结果，特殊情况可以使用此方法
     *
     * @param success 是否成功
     * @param code 状态码
     * @param msg 消息
     * @param data 返回数据
     * @return 构建一个ResponseWrapper
     */
    public static ResponseWrapper markCustom(boolean success, String code, String msg, String data) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(success);
        responseWrapper.setCode(code);
        responseWrapper.setMsg(msg);
        responseWrapper.setData(data);
        return responseWrapper;
    }

    /**
     * 参数为空或者参数格式错误
     *
     * @return 参数为空或者参数格式错误
     */
    public static ResponseWrapper markParamError() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.PARAMS_ERROR.getCode());
        responseWrapper.setMsg(ReturnCode.PARAMS_ERROR.getMsg());
        return responseWrapper;
    }

    /**
     * 查询失败
     *
     * @return 查询失败
     */
    public static ResponseWrapper markError() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.FEAILED.getCode());
        responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 查询失败
     *
     * @return 查询失败
     */
    public static ResponseWrapper markError(String msg) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.FEAILED.getCode());
        responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());
        responseWrapper.setData(msg);
        return responseWrapper;
    }

    /**
     * 查询成功但无数据
     *
     * @return 查询成功但无数据
     */
    public static ResponseWrapper markSuccessButNoData() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.NODATA.getCode());
        responseWrapper.setMsg(ReturnCode.NODATA.getMsg());
        responseWrapper.setData(null);
        return responseWrapper;
    }

    /**
     * 查询成功且有数据
     *
     * @param data 数据
     * @return 查询成功且有数据
     */
    public static ResponseWrapper markSuccess(Object data) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());
        responseWrapper.setData(data);
        return responseWrapper;
    }
}