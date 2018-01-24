/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarEnterParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class CarEnterParkingLotServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private CarEnterParkingLotService carEnterParkingLotServiceImpl;

    @Autowired
    private AccessCurDao accessCurDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testInitCarEnterParkingLotDto() {
        PictureCaptureDto pictureCaptureDto1 = new PictureCaptureDto();
        pictureCaptureDto1.setDevCode("9d5cd970db284a77a44f715fd48f848c");
        pictureCaptureDto1.setImgUrl("http://wwwaa.hdsc/parkinglotcompoment/imgre22345");
        pictureCaptureDto1.setCarNum("粤B-458");
        pictureCaptureDto1.setNumUrl("http://wwwaa.hdsc/parkinglotcompoment/number");
        pictureCaptureDto1.setControlType(1);
        try {
            CarInOutParkingLotDto dto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto1);
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testInitCarEnterParkingLotDto1() {
        PictureCaptureDto pictureCaptureDto = new PictureCaptureDto();
        pictureCaptureDto.setDevCode("222");
        pictureCaptureDto.setCarNum("粤B-11ads11");
        pictureCaptureDto.setControlType(0);
        pictureCaptureDto.setImgUrl("http://wwwaa.hdsc/parkinglotcomaapoment/img");
        pictureCaptureDto.setNumUrl("http://wwwaa.hdsc/paaarkinglotcompoment/numbeaar");
        try {
            CarInOutParkingLotDto dto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCarEnterParkingLot1() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        try {
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        dto.setCarNum("xasee22");
        try {
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCarEnterParkingLot2() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        dto.setCarNum("xas-ee22");
        dto.setCarMode(CarModeType.SMALLCAR.getType());
        try {
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAuthPackageInfo() {
        try {
            carEnterParkingLotServiceImpl.getAuthPackageInfo("粤B-11212", "1001", "恒大停车场");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAuthPackageInfo1() {
        try {
            carEnterParkingLotServiceImpl.getAuthPackageInfo("", "100aa1", "恒大停aa车场");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAuthPackageInfo2() {
        try {
            carEnterParkingLotServiceImpl.getAuthPackageInfo("weeqz", "", "恒大停aa车场1");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testGetAuthPackageInfo3() {
        try {
            carEnterParkingLotServiceImpl.getAuthPackageInfo("weeqz", "456sds", "");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCarEnterParkLot1() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        dto.setOperateType(OperateType.MANUAL.getType());
        dto.setCarNum("");
        try {
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 外部车
     * 
     * @Methods Name testCarEnterParkLot2
     * @Create In 2018年1月16日 By xiaoxiaojie void
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testCarEnterParkLot2() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        dto.setOperateType(OperateType.MANUAL.getType());
        dto.setCarNum("aweew5542");
        try {
            carEnterParkingLotServiceImpl.carEnterParkingLotOperator(dto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void testSelectCountByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("037e3c73f5e24d028e052bb741b099ab");
        ids.add("a76dd685075e42758d099d748f0a98e3");
        logger.info("count=" + accessCurDao.countByPackageIds(ids));
    }

    @Test
    public void testBuildCarInOutDtoInfo() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        carEnterParkingLotServiceImpl.buildCarInOutDtoInfo(dto);
        dto.setCarMode(CarModeType.SMALLCAR.getType());
        dto.setCarType(CarType.PASSENEGER.getType());
        carEnterParkingLotServiceImpl.buildCarInOutDtoInfo(dto);
    }

    @Test
    public void modifyCarInOutDtoTest() {
        CarInOutParkingLotDto dto = getCarEnterParkDto();
        CarInOutDto inOutDtoInfo = carEnterParkingLotServiceImpl.buildCarInOutDtoInfo(dto);
        inOutDtoInfo.setCarNum("");
        carEnterParkingLotServiceImpl.modifyCarInOutDto(inOutDtoInfo);
        inOutDtoInfo.setCarNum("xdjjrr");
        carEnterParkingLotServiceImpl.modifyCarInOutDto(inOutDtoInfo);
        inOutDtoInfo.setCarNum("粤B-458");
        carEnterParkingLotServiceImpl.modifyCarInOutDto(inOutDtoInfo);

    }

    public CarInOutParkingLotDto getCarEnterParkDto() {
        CarInOutParkingLotDto dto = new CarInOutParkingLotDto();
        dto.setDirect(ChannelDirectType.ENTRANCE.getType());
        ParkChannel channel = new ParkChannel();
        channel.setUuid(UuidUtil.generate());
        channel.setDirect(ChannelDirectType.ENTRANCE.getType());
        ParkParkingLot parkingLot = new ParkParkingLot();
        parkingLot.setUuid(UuidUtil.generate());
        parkingLot.setParkRuleId("f84bedf2ab884e399a5ffb223d63222d");
        parkingLot.setParkCode("HD-aawe11");
        dto.setOperateType(OperateType.AUTO.getType());

        dto.setChannelId(channel.getUuid());
        dto.setChannelName(channel.getName());
        dto.setChannelIP(channel.getIp());
        dto.setParkinglotUuid(parkingLot.getUuid());
        dto.setParkCode(parkingLot.getParkCode());
        dto.setCarInOutCurrentTime(new Date());
        return dto;
    }
}
