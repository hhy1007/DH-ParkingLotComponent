/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.car.SwipeCarInParkinglotService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.ICCardDto;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * @Class Name SwipeEnterParkinglotServiceTest
 * @Author xiaoxiaojie
 * @Create In 2018年1月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class SwipeCarInParkinglotServiceTest {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private SwipeCarInParkinglotService swipeCarInParkinglotServiceImpl;
    
    @Test
    public void  testInitCarInParkinglotInfo() {
        ICCardDto icCardDto = new ICCardDto();
        icCardDto.setOwnerId("adfwuyr5474");
        icCardDto.setCarNum("xue-dfw");
        icCardDto.setCardNumber("12xw3x21");
        icCardDto.setDevCode("12333");
        try {
            swipeCarInParkinglotServiceImpl.initCarInParkinglotInfo(icCardDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
    
    @Test
    public void  testInitCarInParkinglotInfo1() {
        ICCardDto icCardDto = new ICCardDto();
        icCardDto.setCarNum("xue-dfw");
        icCardDto.setOwnerId("adfwu12143yr5474");
        icCardDto.setDevCode("441");
        icCardDto.setCardNumber("12xwW!!@3x21");
        try {
            swipeCarInParkinglotServiceImpl.initCarInParkinglotInfo(icCardDto);
        } catch (Exception e) {
            logger.info("testInitCarInParkinglotInfo1 error="+e.getMessage());
        }
    }
    
    @Test
    public void swipeEnterParkinglotOperatorTest() {
        CarInOutParkingLotDto carInOutParkingLotDto = new CarInOutParkingLotDto();
        carInOutParkingLotDto.setDirect(ChannelDirectType.EXPROTATION.getType());
        ICCardDto icCardDto = new ICCardDto();
        swipeCarInParkinglotServiceImpl.swipeEnterParkinglotOperator(carInOutParkingLotDto, icCardDto);
        icCardDto.setCarNum("浙A-aa1asw");
        icCardDto.setOwnerId("asdfweweqafdqr");
        CarInOutParkingLotDto dtoInfo = getCarEnterParkDtoInfo();
        try {
            swipeCarInParkinglotServiceImpl.swipeEnterParkinglotOperator(dtoInfo, icCardDto);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
        
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void swipeEnterParkinglotOperatorTest1() {
        CarInOutParkingLotDto dtoInfo = getCarEnterParkDtoInfo();
        ICCardDto icCardDto = new ICCardDto();
        dtoInfo.setOperateType(OperateType.MANUAL.getType());
        icCardDto.setCardNumber("2#$!DSSAHF");
        icCardDto.setCarNum("浙C-agasw");
        try {
            swipeCarInParkinglotServiceImpl.swipeEnterParkinglotOperator(dtoInfo, icCardDto);
        } catch (Exception e) {
           logger.info(e.getMessage());
        }
        icCardDto.setOwnerId("aswwXEEE");
        try {
            swipeCarInParkinglotServiceImpl.swipeEnterParkinglotOperator(dtoInfo, icCardDto);
        } catch (Exception e) {
           logger.info("error :="+e.getMessage());
        }
    }
    
    
    public CarInOutParkingLotDto getCarEnterParkDtoInfo() {
        CarInOutParkingLotDto carInOutParkingLotDto =new CarInOutParkingLotDto();
        ParkParkingLot parkingLot =new ParkParkingLot();
        ParkChannel channel = new ParkChannel();
        channel.setUuid(UuidUtil.generate());
        parkingLot.setUuid(UuidUtil.generate());
        channel.setParkCode("HD-aawe111123412awewe");
        channel.setDirect(ChannelDirectType.ENTRANCE.getType());
        parkingLot.setParkRuleId("f84bedfrqwerqw");
        parkingLot.setParkCode("HD-aawe111123412");
        carInOutParkingLotDto.setOperateType(OperateType.AUTO.getType());
        carInOutParkingLotDto.setParkinglotUuid(parkingLot.getUuid());
        carInOutParkingLotDto.setParkCode(parkingLot.getParkCode());
        carInOutParkingLotDto.setDefaultRuleId(parkingLot.getParkRuleId());
        carInOutParkingLotDto.setChannelId(channel.getUuid());
        carInOutParkingLotDto.setChannelName(channel.getName());
        carInOutParkingLotDto.setChannelIP(channel.getIp());
        carInOutParkingLotDto.setDirect(ChannelDirectType.ENTRANCE.getType());
        carInOutParkingLotDto.setCarInOutCurrentTime(new Date());
        return carInOutParkingLotDto;
    }
}
