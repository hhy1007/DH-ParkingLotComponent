/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car;

import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDto;

/**
 * 车辆进场逻辑服务接口
 * @Class Name ICarEnterParkingLotService
 * @Author xiaoxiaojie
 * @Create In 2017年12月19日
 */
public interface CarEnterParkingLotService {
    
    
    //初始化数据
    
    /**
     *  初始化车辆进出停车场Dto类
     * @Methods Name initCarEnterParkingLotDto
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param pictureCaptureDto
     * @return CarInOutParkingLotDto
     */
    CarInOutParkingLotDto initCarEnterParkingLotDto(PictureCaptureDto pictureCaptureDto);
    
    /**
     * 验证车辆入场数据
     * @Methods Name validData
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @return boolean
     */
    boolean validData(CarInOutParkingLotDto carInOutParkingLotDto);
    /**
     * 处理车辆进场逻辑
     * @Methods Name carEnterParkingLotOperator
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param carInOutParkingLotDto void
     */
    void carEnterParkingLotOperator(CarInOutParkingLotDto carInOutParkingLotDto);
    
    /**
     * 处理停车场应用通知和保存数据方法
     * @Methods Name handleNoticeAndData
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param enterMode void
     */
    void handleNoticeAndData(CarInOutParkingLotDto carInOutParkingLotDto,Short enterMode);
    /**
     * 根据车牌,业主Id,停车场编号查询授权套餐
     * @Methods Name getAuthPackageInfo
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param carNum
     * @param ownerId
     * @param parkCode
     * @return AuthPackage
     */
    AuthPackage getAuthPackageInfo(String carNum,String ownerId,String parkCode);

    /**
     * 获得车道信息
     * @Methods Name getChannelInfo
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param devCode
     * @return ParkChannel
     */
    ParkChannel getChannelInfo(String  devCode);
    
    /**
     * 根据车场编号查询车场信息
     * @Methods Name queryParkingLotInfoByParkCode
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param parkCode
     * @return ParkParkingLot
     */
    ParkParkingLot queryParkingLotInfoByParkCode(String parkCode);
    
    /**
     * 获取进出场规则
     * @Methods Name getCarInOutRule
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param parkRuleId
     * @return RuleDto
     */
    RuleDto getCarInOutRule(String parkRuleId);
    
    /**
     * 根据进出规则处理车辆入场
     * @Methods Name parkCarByRule
     * @Create In 2018年1月10日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param ruleDto void
     */
    void parkCarByRule(CarInOutParkingLotDto carInOutParkingLotDto, RuleDto ruleDto);
    /**
     * 根据通道ID和设备类型查询设备编号
     * @Methods Name queryBarrierGateDevCode
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param channelId
     * @param devType
     * @return String
     */
    String queryBarrierGateDevCode(String channelId,Short devType);
    
    /**
     * 根据业主id查询业主名称
     * @Methods Name getOwnerNameById
     * @Create In 2018年1月9日 By xiaoxiaojie
     * @param ownerId
     * @return String
     */
    String getOwnerNameById(String ownerId);
    
    /**
     * 封装车辆入场dto信息
     * @Methods Name buildCarInOutDtoInfo
     * @Create In 2018年1月11日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @return CarInOutDto
     */
    CarInOutDto buildCarInOutDtoInfo(CarInOutParkingLotDto carInOutParkingLotDto);
    
    /**
     * 车辆进场修改车牌更新相应的套餐和进出规则
     * @Methods Name modifyCarInOutDtoByCarNum
     * @Create In 2018年1月15日 By xiaoxiaojie
     * @param carInOutDto
     * @return ResultMessage
     */
    ResultMessage modifyCarInOutDto(CarInOutDto carInOutDto);
    /**
     * 保存结构化数据，1.在场车辆记录表。2.停车历史记录表。3.余位。
     * @Methods Name saveCarInOutData
     * @Create In 2018年1月14日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param enterMode void
     */
    void saveCarInOutData(CarInOutParkingLotDto carInOutParkingLotDto, Short enterMode);
    
    /**
     * 判断个人车位是否已满
     * @Methods Name privateCarPortIsFull
     * @Create In 2018年1月22日 By xiaoxiaojie
     * @param ownerId
     * @param parkCode
     * @return boolean
     */
    boolean privateCarPortIsFull(String ownerId, String parkCode);
    
    /**
     * 处理过期的月保产权车
     * @Methods Name handleOverdueMonthCar
     * @Create In 2018年1月22日 By xiaoxiaojie
     * @param carInOutParkingLotDto
     * @param defaultRuleDto
     * @param ruleDto void
     */
    void handleOverdueMonthCar(CarInOutParkingLotDto carInOutParkingLotDto,
            RuleDto defaultRuleDto, RuleDto ruleDto);
}
