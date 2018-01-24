/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.syscode;

import java.util.Map;


/**
 * 字典表操作接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface SysCodeService {
    
    /**
     * 字典信息： 车牌颜色
     * 
     * @return Map<String,String>
     */
    Map<String, String> getCarNumColorMap();

    /**
     * 字典信息： 车辆颜色
     * 
     * @return Map<String,String>
     */
    Map<String, String> getCarColorMap();
    
    /**
     * 字典信息： 车辆品牌
     * 
     * @return Map<String,String>
     */
    Map<String, String> getCarBrandMap();

    /**
     * 字典信息： 车型
     * 
     * @return Map<String,String>
     */
    Map<String, String> getCarModeMap();

}
