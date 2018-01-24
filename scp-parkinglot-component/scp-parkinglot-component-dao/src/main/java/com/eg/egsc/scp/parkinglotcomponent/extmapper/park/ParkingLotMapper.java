/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.park;

import java.util.List;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkingLotMapper {

    /**
     * 根据多个规则id查询停车场授权服务套餐
     * 
     * @param ruleIds
     * @return List<ParkParkingLot>
     */
    List<ParkParkingLot> selectParkParkingLotAndParkPackageParkRelByRuleIds(List<String> ruleIds);

    /**
     * 根据停车场名称和编号查询名称相同编号不同停车场信息
     * 
     * @param parkParkingLot
     * @return ParkParkingLot
     */
    ParkParkingLot selectParkParkingLotByName(ParkParkingLot parkParkingLot);

    /**
     * 根据停车场编号或停车场名称查询停车场信息
     * 
     * @param parkParkingLot
     * @return ParkParkingLot
     */
    ParkParkingLot selectParkParkingLot(ParkParkingLot parkParkingLot);

    /**
     * 根据收费规则id查询服务套餐信息
     * 
     * @param feeRuleIds
     * @return List<ParkParkingLot>
     */
    List<ParkParkingLot> selectParkParkingLotAndParkPackageParkRel(List<String> feeRuleIds);

    /**
     * 根据车场id更新余位（余位自减1）
     * 
     * @param id
     * @return int
     */
    int updateParkingLotSelfReduction(String id);

    /**
     * 根据车场id更新余位（余位自加1）
     * 
     * @param id
     * @return int
     */
    int updateParkingLotSelfAdd(String id);

    /**
     * 根据车位编号更新车场
     * 
     * @param curRecord
     * @return int
     */
    int updateByCode(ParkParkedCur curRecord);
}
