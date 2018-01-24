/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;

/**
 * 诱导屏绑定车位管理业务层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkCarportRelService {

    /**
     * 添加诱导屏绑定车位
     * 
     * @param parkLedCarportRel
     * @return int
     */
    int insert(ParkLedCarportRel parkLedCarportRel);

    /**
     * 更新诱导屏绑定车位
     * 
     * @param parkLedCarportRel
     * @return int
     */
    int update(ParkLedCarportRel parkLedCarportRel);

    /**
     * 删除诱导屏绑定车位
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 诱导屏绑定车位信息分页查询
     * 
     * @param condition
     * @return Page<ParkLedCarportRel>
     */
    Page<ParkLedCarportRel> selectPageList(CarportRelCondition condition);

    /**
     * 诱导屏绑定车位信息查询
     * 
     * @param condition
     * @return List<ParkLedCarportRel>
     */
    List<ParkLedCarportRel> selectList(CarportRelCondition condition);
    
    
    /**
     * 根据led设备编号查询车位与设备绑定信息
     * 
     * @param ledCodes
     * @return List<ParkLedCarportRel>
     */
    List<ParkLedCarportRel> selectLedCarportRelByLedCode(String ledCode);
    
    /**
     * 根据led设备编号删除车位与设备绑定信息
     * 
     * @param ledCodes
     * @return int
     */
    int deleteByLedCode(String ledCode);
    
    /**
     * 根据id查询诱导屏绑定车位信息
     * 
     * @param uuid
     * @return ParkLedCarportRel
     */
    ParkLedCarportRel selectByPrimaryKey(String uuid);

}
