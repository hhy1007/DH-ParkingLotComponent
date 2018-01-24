/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.exception;

import com.eg.egsc.common.exception.CommonException;

/**
 * @Class Name BusinessExceptions
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class BusinessExceptions extends CommonException {

    private static final long serialVersionUID = 1817037495049619471L;

    public BusinessExceptions(String message) {
        super(message);
    }

    public BusinessExceptions(String code, String errMsg) {
        super(code, errMsg);
    }

    public BusinessExceptions(String message, String code, Object[] values, Throwable throwable) {
        super(message, code, values, throwable);
    }

}
