/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.park;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkExitParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotInformationStoredService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/park")
public class ParkExitParkingLotController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkParkingLotInformationStoredService parkParkingLotInformationStoredServiceImpl;// 出口储久化结构性信息

    @Autowired
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;// 初始化功能

    @Autowired
    private ParkExitParkingLotService parkExitParkingLotServiceImpl;// 出场逻辑service

    /**
     * 结构化储存信息
     * 
     * @Methods Name exitControl
     * @Create In 2017年12月22日 By wangziqiang
     * @param CarInOutParkingLotDto
     */
    @ApiOperation(value = "结构化储存信息", notes = "根据传入参数持久化信息")
    @RequestMapping(value = "/exitControl/insert", method = RequestMethod.POST)
    @Transactional
    public ResultMessage exitControl(@Valid @RequestBody CarInOutDto carInOutDto) {
        logger.info("exitControl param" + JSON.toJSONString(carInOutDto));

        this.parkParkingLotInformationStoredServiceImpl.storeCarInformation(carInOutDto);
        return ResultMessage.createSuccessResult("success");
    }


    @ApiOperation(value = "出场初始化实体类信息", notes = "根据设备出场初始化实体类信息")
    @RequestMapping(value = "/initCarDtoControl/get", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "devCode", required = true, paramType = "query",
                    dataType = "String", value = "设备号"),
            @ApiImplicitParam(name = "carNum", required = true, paramType = "query",
                    dataType = "String", value = "车牌号"),
            @ApiImplicitParam(name = "imgUrl", required = true, paramType = "query",
                    dataType = "String", value = "车辆图片"),
            @ApiImplicitParam(name = "numUrl", required = true, paramType = "query",
                    dataType = "String", value = "车牌图片")})
    public ResultMessage initCarDtoControl(@RequestParam String devCode,
            @RequestParam String carNum, @RequestParam String imgUrl, @RequestParam String numUrl) {
        PictureCaptureDto pictureCaptureDto = new PictureCaptureDto();
        pictureCaptureDto.setDevCode(devCode);
        pictureCaptureDto.setCarNum(carNum);
        pictureCaptureDto.setImgUrl(imgUrl);
        pictureCaptureDto.setNumUrl(numUrl);
        CarInOutParkingLotDto carInOutParkingLotDto =
                this.carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
        return ResultMessage.createSuccessResult(carInOutParkingLotDto);
    }

    /**
     * 出场逻辑
     * 
     * @Methods Name exitParkingLot
     * @Create In 2017年12月28日 By wangziqiang
     * @param carInOutParkingLotDto
     * @return ResultMessage
     */
    @ApiOperation(value = "出场逻辑", notes = "根据初始化实体类信息进行出场逻辑判断")
    @RequestMapping(value = "/exitParkingLot/bitch<insert>", method = RequestMethod.POST)
    public ResultMessage exitParkingLot(
            @Valid @RequestBody CarInOutParkingLotDto carInOutParkingLotDto) {
        parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        return ResultMessage.createSuccessResult("success");
    }


}
