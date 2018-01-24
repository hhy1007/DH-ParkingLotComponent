/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;

/**
 * 停车场管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkParkingLotService {

    /**
     * 根据id查询停车场信息
     * 
     * @param uuid
     * @return ParkChannelService
     */
    ParkParkingLot selectByPrimaryKey(String uuid);
    
    /**
     * 添加停车场
     * 
     * @param parkParkingLot
     * @return int
     */
    int insert(ParkParkingLot parkParkingLot);

    /**
     * 更新停车场
     * 
     * @param parkParkingLot
     * @return int
     */
    int update(ParkParkingLot parkParkingLot);

    /**
     * 删除停车场
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 停车场信息分页查询
     * 
     * @param condition
     * @return Page<ParkParkingLot>
     */
    Page<ParkParkingLot> selectPageList(ParkingLotCondition condition);

    /**
     * 停车场信息查询
     * 
     * @param condition
     * @return List<ParkParkingLot>
     */
    List<ParkParkingLot> selectList(ParkingLotCondition condition);

}
