/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carcapture;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;

/**
 * 抓拍业务层接口
 * 
 * @Class Name ICarCaptureService
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
public interface CarCaptureService {
	/**
     * 抓拍数据分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月15日 By xiangdaoping
     * @param condition
     * @return Page<ParkCarCapture>
     */
    Page<ParkCarCapture> selectPageList(CarCaptureCondition condition);
    
    /**
     * 抓拍数据信息查询
     * 
     * @Methods Name selectList
     * @Create In 2017年12月15日 By xangdaoping
     * @param condition
     * @return List<ParkCarCapture>
     */
    List<ParkCarCapture> selectList(CarCaptureCondition condition);
	
    /**
     * 添加相机抓拍记录
     * @Methods Name insert
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkCarCapture
     * @return int
     */
    int insert(ParkCarCapture parkCarCapture);
    
    /**
     * 根据id 删除相机抓拍记录
     * @Methods Name deleteById
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param id
     * @return int
     */
    int deleteById(String id);
    
    /**
     * 更新相机抓拍记录
     * @Methods Name update
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param parkCarCapture
     * @return int
     */
    int update(ParkCarCapture parkCarCapture);
    
    /**
     * 根据id 查询相机抓拍记录
     * @Methods Name selectByPrimaryKey
     * @Create In 2017年12月25日 By xiaoxiaojie
     * @param id
     * @return ParkCarCapture
     */
    ParkCarCapture selectByPrimaryKey(String id);
}
