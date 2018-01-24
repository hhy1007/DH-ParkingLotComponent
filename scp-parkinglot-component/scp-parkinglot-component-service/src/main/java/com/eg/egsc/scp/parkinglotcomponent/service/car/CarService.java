/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarBatchOptDto;

/**
 * 车辆管理业务层接口
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
public interface CarService {
    
   
    /**
     * 根据id批量修改车辆信息(修改特定的字段)
     * 
     * @param batchOptDto
     * @return int
     */
    public int updateStatusByids(CarBatchOptDto batchOptDto);

    /**
     * 根据id修改车辆信息(修改特定的字段)
     * 
     * @param car
     * @return int
     */
    int updateStatus(ParkCar car);
    
    /**
     * 添加车辆
     * 
     * @param car
     * @return int
     */
    int insert(ParkCar car);

    /**
     * 更新车辆车辆
     * 
     * @param car
     * @return int
     */
    int update(ParkCar car);

    /**
     * 更新车辆车辆
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 车辆信息分页查询
     * 
     * @param condition
     * @return Page<ParkCar>
     */
    Page<ParkCar> selectPageList(CarCondition condition);
    
    /**
     * 车辆信息查询
     * 
     * @param condition
     * @return List<ParkCar>
     */
    List<ParkCar> selectList(CarCondition condition);

    /**
     * 通过id查询
     * 
     * @param id
     * @return ParkCar
     */
    ParkCar selectById(String id);
    

    /**
     * 通过车牌号码查询
     * 
     * @param carNum
     * @return ParkCar
     */
    ParkCar selectByCarNum(String carNum);
    
    /**
     * 车辆信息批量导入
     * 
     * @param carList
     * @return int
     */
    public int insertCarBatch(List<ParkCar> carList);
}
