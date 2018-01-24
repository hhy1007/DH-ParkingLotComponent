/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * rest请求返回结果
 * 
 * @Class Name ResultMessage
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class ResultMessage {

    private static final SerializerFeature[] JSON_SERIALIZER_FEATURES =
            new SerializerFeature[] {SerializerFeature.DisableCircularReferenceDetect};

    // 结果编码
    private String code;

    // 错误消息
    private String message;

    // 返回数据
    private Object data;


    public String toJSONString() {
        return JSON.toJSONString(this, JSON_SERIALIZER_FEATURES);
    }

    public String toJSONStringWithDateFormat(String dateFormat) {
        return JSON.toJSONStringWithDateFormat(this, dateFormat, JSON_SERIALIZER_FEATURES);
    }

    public ResultMessage() {}

    public ResultMessage(Object data) {
        this.code = ResultCode.SUCCESS;
        this.message = ResultCode.SUCCESS_MESSAGE;
        this.data = data;
    }

    public ResultMessage(String message) {
        this.message = message;
    }

    public ResultMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultMessage(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResultMessage(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 创建成功返回消息
     *
     * @param data
     * @return
     */
    public static ResultMessage createSuccessResult(Object data) {
        return new ResultMessage(data);
    }


    /**
     * 创建错误返回消息
     *
     * @param code
     * @param errMsg
     * @param data
     * @return
     */
    public static ResultMessage createErrorResult(String code, String errMsg, Object data) {
        return new ResultMessage(code, errMsg, data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public ResultMessage setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResultMessage{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data
                + '}';
    }
}
