/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.car;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;

/**
 * 车辆入场控制层
 * @Class Name CarEnterParkingLotController
 * @Author xiaoxiaojie
 * @Create In 2018年1月9日
 */
@RestController
@RequestMapping(value = "/carEnterParkingLot")
public class CarEnterParkingLotController extends BaseWebController {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;
    
    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ResultMessage carEnterParkingLotService(@Valid @RequestBody PictureCaptureDto pictureCaptureDto){
        
        logger.info("selectPageList param: " + JSON.toJSONString(pictureCaptureDto));
        CarInOutParkingLotDto carEnterParkingLotDto = carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
        carEnterParkingLotServiceImpl.carEnterParkingLotOperator(carEnterParkingLotDto);
        return ResultMessage.createSuccessResult(carEnterParkingLotDto);
    }
}
