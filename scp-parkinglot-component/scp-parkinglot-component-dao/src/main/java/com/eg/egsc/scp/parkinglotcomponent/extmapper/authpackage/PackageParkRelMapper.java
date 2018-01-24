/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;

/**
 * 授权套餐车场自定义mapper
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface PackageParkRelMapper {
    
    /**
     * 批量插入
     * 
     * @param packageParkRels
     * @return int
     */
    int insertPackageParkRelBatch(List<ParkPackageParkRel> packageParkRels);

}
