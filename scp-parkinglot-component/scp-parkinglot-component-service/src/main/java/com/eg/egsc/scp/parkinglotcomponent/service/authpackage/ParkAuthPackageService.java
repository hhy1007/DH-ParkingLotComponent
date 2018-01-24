/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.authpackage;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.dto.AuthPackageDto;

/**
 * 授权套餐业务接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface ParkAuthPackageService {
    
    /**
     * 授权套餐新增
     * 
     * @param authPackage
     * @return int
     */
    int insert(AuthPackage authPackage);
    
    /**
     * 修改授权套餐
     * 
     * @param authPackage
     * @return int
     */
    int update(AuthPackage authPackage);
    
    /**
     * 批量删除授权套餐
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);
    
    /**
     * 授权套餐分页查询
     * 
     * @param condition
     * @return Page<AuthPackage>
     */
    Page<AuthPackage> selectPageList(ParkAuthPackageCondition condition);
    
    /**
     * 授权套餐条件查询
     * 
     * @param condition
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectList(ParkAuthPackageCondition condition);
    
    
    /**
     * 通过车牌查询缴费信息
     * 
     * @param carNum
     * @return List<AuthPackageDto>
     */
    List<AuthPackageDto> getMonthCarByCarNum(String carNum);
    
    /**
     * 通过车主姓名查询缴费信息
     * 
     * @param ownerName
     * @return List<AuthPackageDto>
     */
    List<AuthPackageDto> getMonthCarByOwnerName(String ownerName);
    
}
