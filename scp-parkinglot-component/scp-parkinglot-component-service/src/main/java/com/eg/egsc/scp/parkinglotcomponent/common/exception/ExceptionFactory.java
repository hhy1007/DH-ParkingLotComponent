/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.exception;

/**
 * 异常工厂类
 * 
 * @Class Name ExceptionFactory
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class ExceptionFactory {

    private ExceptionFactory () {
    }
    
    public static BusinessExceptions createSysException(String errMsg) {
        return new BusinessExceptions(errMsg);
    }

}
