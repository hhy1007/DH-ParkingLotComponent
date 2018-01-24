/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;

/**
 * 授权套餐自定义mapper
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface AuthPackageMapper {
    
    /**
     * 条件分页查询总数量
     * 
     * @param condition
     * @return int
     */
    int countByExample(ParkAuthPackageCondition condition);
    
    /**
     * 条件分页查询
     * 
     * @param condition
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectByExampleWithRowbounds(ParkAuthPackageCondition condition);
    
    /**
     * 条件查询
     * 
     * @param condition
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectByExample(ParkAuthPackageCondition condition);
    
    /**
     * 根据用户id批量查询(除去临时停车用户)
     * 
     * @param ownerIds
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectByOwnerIdsWithoutTemp(List<String> ownerIds);
    
    /**
     * 根据Id批量查询
     * 
     * @param ids
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectByIds(List<String> ids);
    
    /**
     * 根据车位号批量查询
     * 
     * @param carportCodes
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectBycarportCodes(List<String> carportCodes);
    
    /**
     * 根据用户id批量查询
     * 
     * @param ownerIds
     * @return List<AuthPackage>
     */
    List<AuthPackage> selectByOwnerIds(List<String> ownerIds);
    
}
