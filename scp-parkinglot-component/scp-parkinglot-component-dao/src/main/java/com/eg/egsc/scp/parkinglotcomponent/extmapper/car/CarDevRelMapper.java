/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarDevRelConditon;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;

/**
 * @Class Name CarDevRelMapper
 * @Author huangyuhong
 * @Create In 2017年12月29日
 */
public interface CarDevRelMapper {

    /**
     * 批量新增
     * 
     * @Methods Name insertPackageCarRelBatch
     * @Create In 2017年12月29日 By huangyuhong
     * @param parkCarDevRelList
     * @return int
     */
    int insertPackageCarRelBatch(List<ParkCarDevRel> parkCarDevRelList);


    /**
     * 根据车牌号和车场号批量修改下发表
     * 
     * @Methods Name updateStatusByCarNumsAndParkCodes
     * @Create In 2018年1月5日 By huangyuhong
     * @param parkCarDevRel
     * @param carDevRelDto
     * @return int
     */
    int updateStatusByCarNumsAndParkCodes(@Param("carDevRel") ParkCarDevRel parkCarDevRel,
            @Param("carDevList") List<CarDevRelConditon> carDevRelDto);

    /**
     * 根据id批量修改车辆下发表
     * 
     * @Methods Name updateStatusByIds
     * @Create In 2018年1月5日 By huangyuhong
     * @param ids
     * @return int
     */
    int updateStatusByDevCodes(@Param("carDevRel") ParkCarDevRel parkCarDevRel,
            @Param("ids") List<String> ids);

}
