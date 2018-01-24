/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.car;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @Class Name CarMapper
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public interface CarMapper {

    /**
     * 根据id修改车辆信息(修改特定的字段)
     * 
     * @Methods Name updateCar
     * @Create In 2017年12月28日 By fengrongjun
     * @param car
     * @return int
     */
    int updateCar(ParkCar car);

    /**
     * 根据id批量删除<p>
     * 
     * * @Methods Name deleteByIds * @Create In 2017年12月13日 By zhangli *
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 查询条数接口
     * 
     * @Methods Name countByExample
     * @Create In 2018年1月8日 By zhangli
     * @param condition
     * @return int
     */
    int countByExample(CarCondition condition);

    /**
     * 支持分页查询接口
     * 
     * @Methods Name selectByExampleWithRowbounds
     * @Create In 2018年1月8日 By zhangli
     * @param condition
     * @return List<ParkCar>
     */
    List<ParkCar> selectByExampleWithRowbounds(CarCondition condition);
    
    /**
     * 批量插入车辆信息
     * 
     * @Methods Name insertCarBatch
     * @Create In 2018年1月4日 By huangyuhong
     * @param carList
     * @return int
     */
    int insertCarBatch(List<ParkCar> carList);
    
    /**
     * 通过车牌批量查找车辆(用于批量插入验证)
     * 
     * @Methods Name selectCarByCarNums
     * @Create In 2018年1月4日 By huangyuhong
     * @param carNums
     * @return List<ParkCar>
     */
    List<ParkCar> selectCarByCarNums(List<String> carNums);

}
