/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.access;

import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;

/**
 * 
 * @Class Name IRoadGateService
 * @Author xiaoxiaojie
 * @Create In 2017年12月22日
 */
public interface RoadGateService {
    
    /**
     * 道闸指令控制接口
     * @Methods Name cutOffRoadGateCommand
     * @Create In 2017年12月22日 By xiaoxiaojie
     * @param devCode
     * @param controlType
     * @param car
     * @return String
     */
    String cutOffRoadGateCommand(String devCode,int controlType,CarInOutDto carInOutDto);
     
      /**
      * 手动道闸指令控制接口
      * @Methods Name autoCutOffRoadGateCommand
      * @Create In 2018年1月5日 By wangziqiang
      * @param devCode
      * @param controlType
      * @param carInOutDto
      * @param staffId
      * @param staffName
      * @return String
      */
    String manualCutOffRoadGateCommand(String devCode,int controlType,CarInOutDto carInOutDto,String staffId,String staffName);
    
    /**
     * 
     * @Methods Name confirmCutOffRoadGateCommand
     * @Create In 2018年1月16日 By xiaoxiaojie
     * @param devCode
     * @param controlType
     * @param carInOutDto void
     */
    void confirmCutOffRoadGateCommand(String devCode, int controlType,CarInOutDto carInOutDto);
}
