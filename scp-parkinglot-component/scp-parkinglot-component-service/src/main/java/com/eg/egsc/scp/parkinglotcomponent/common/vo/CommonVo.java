/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.vo;

/**
 * @Class Name CommonVo
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <T>
 */
public class CommonVo<T> {


    private BaseHeader header;

    private T body;

    public BaseHeader getHeader() {
        return header;
    }

    public void setHeader(BaseHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
