/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;

/**
 * 授权套餐车辆自定义mapper
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface PackageCarRelMapper {
    
    /**
     * 批量插入
     * 
     * @param packageCarRels
     * @return int
     */
    int insertPackageCarRelBatch(List<ParkPackageCarRel> packageCarRels);

}
