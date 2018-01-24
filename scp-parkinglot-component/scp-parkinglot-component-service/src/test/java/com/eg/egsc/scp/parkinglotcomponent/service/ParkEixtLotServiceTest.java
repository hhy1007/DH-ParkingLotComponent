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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.ChannelDirectType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarInOutParkingLotDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.PictureCaptureDto;
import com.eg.egsc.scp.parkinglotcomponent.service.car.impl.CarEnterParkingLotServiceImpl;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkExitParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
/**
 * 出场逻辑测试类
 * 
 * @Class Name ParkParkingLotInformationStoredAndInitCarInOutDtoServiceTest
 * @Author wangziqiang
 * @Create In 2018年1月15日
 */
public class ParkEixtLotServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * @Filed 相机设备
     */
    private static final String DEVCODE = "222";
    /**
     * @Filed 图片
     */
    private static final String IMGURL = "http://www.hdsc/parkinglotcompoment/img";

    /**
     * @Filed 车牌图片
     */
    private static final String NUMURL = "http://www.hdsc/parkinglotcompoment/numUrl";
    /**
     * @Filed 自动开闸
     */
    private static final int CONTROLTYPE1 = 0;
    /**
     * @Filed 手动开闸
     */
    private static final int CONTROLTYPE2 = 1;
    /**
     * @Filed 车牌1
     */
    private static final String CARNUM1 = "粤B-457";
    /**
     * @Filed 车牌2
     */
    private static final String CARNUM2 = "粤B-458";
    /**
     * @Filed 车牌3
     */
    private static final String CARNUM3 = "粤B-459";
    /**
     * @Filed 车牌4
     */
    private static final String CARNUM4 = "粤B-456";

    /**
     * @Filed 车牌5
     */
    private static final String CARNUM5 = "粤B-461";

    @Resource
    private CarEnterParkingLotServiceImpl carEnterParkingLotServiceImpl;
    @Autowired
    private ParkExitParkingLotService parkExitParkingLotServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试手动模式下有车牌 有在场记录的有未过期授权套餐出场逻辑
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto() {// TT
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, CARNUM1, IMGURL, NUMURL);
        CarInOutParkingLotDto carInOutParkingLotDto =
                carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
        try {
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 得到PictureCaptureDto
     * 
     * @param numurl
     * @param imgurl
     * @param carnum
     * @param controltype
     * @param devcode
     * @Methods Name getPictureCaptureDto
     * @Create In 2018年1月16日 By wangziqiang
     * @return PictureCaptureDto
     */
    private PictureCaptureDto getPictureCaptureDto(String devcode, int controltype, String carnum,
            String imgurl, String numurl) {
        PictureCaptureDto pictureCaptureDto = new PictureCaptureDto();
        pictureCaptureDto.setDevCode(devcode);
        pictureCaptureDto.setControlType(controltype);
        pictureCaptureDto.setCarNum(carnum);
        pictureCaptureDto.setImgUrl(imgurl);
        pictureCaptureDto.setNumUrl(numurl);
        return pictureCaptureDto;
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试自动模式下有车牌 有在场记录的有未过期授权套餐出场逻辑
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto01() {// TT

        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE1, CARNUM1, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试手动模式有车牌 有在场记录的有过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto11() {// TT
        // 有车牌 有在场记录的有过期授权套餐
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, CARNUM2, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试自动模式有车牌 有在场记录的有过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto12() {// TT
        // 有车牌 有在场记录的有过期授权套餐
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE1, CARNUM2, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试手动模式下有车牌 无在场记录的有过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto41() {// TT
        // 自动有车牌 无在场记录的有未过期授权套餐
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, CARNUM3, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试自动模式下 有车牌 无在场记录的有过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto42() {// TT
        // 自动有车牌 无在场记录的有过期授权套餐
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE1, CARNUM3, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试自动 有车牌 无在场记录的有未过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto31() {// TT
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE1, CARNUM4, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试手动模式下 有车牌 无在场记录的有未 过期授权套餐出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto32() {// TT
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, CARNUM4, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试手动模式下无车牌出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto51() {// TT
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, "", IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试自动动模式下无车牌出场
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto52() {// TT
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE1, "", IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 测试手动模式下 有车牌 有在场记录 特殊车辆
     * 
     * @Methods Name testInitCarEnterParkingLotDto61
     * @Create In 2018年1月22日 By wangziqiang void
     */
    public void testInitCarEnterParkingLotDto61() {
        PictureCaptureDto pictureCaptureDto =
                getPictureCaptureDto(DEVCODE, CONTROLTYPE2, CARNUM5, IMGURL, NUMURL);
        try {
            CarInOutParkingLotDto carInOutParkingLotDto =
                    carEnterParkingLotServiceImpl.initCarEnterParkingLotDto(pictureCaptureDto);
            parkExitParkingLotServiceImpl.exitParkingLot(carInOutParkingLotDto);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试修改车牌
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testSelectCarInOutInformation() {
        CarInOutDto carInOutDto = getCarInOut();
        carInOutDto.setCarNum(CARNUM2);
        try {
            CarInOutDto carInOutDto1 =
                    parkExitParkingLotServiceImpl.selectCarInOutInformation(carInOutDto);
            logger.info("result :" + JSONObject.toJSONString(carInOutDto1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * <p>
     * 测试修改车辆模型
     * 
     * @Methods Name testInitCarEnterParkingLotDto
     * @Create In 2017年12月27日 By wangziqiang void
     */
    public void testReBilling() {
        CarInOutDto carInOutDto = getCarInOut();
        try {
            CarInOutDto carInOutDto1 = parkExitParkingLotServiceImpl.reBilling(carInOutDto);
            logger.info("result : {}" + JSONObject.toJSONString(carInOutDto1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 得到CarInOutDto
     * 
     * @Methods Name getCarInOut
     * @Create In 2018年1月15日 By wangziqiang
     * @return CarInOutDto
     */
    protected CarInOutDto getCarInOut() {
        CarInOutDto carInOutDto = new CarInOutDto();
        carInOutDto.setCardNumber("");
        carInOutDto.setCarNum(CARNUM1);
        carInOutDto.setCarMode("1");
        carInOutDto.setCarportType(CarportType.MONTHWARRANTY.getType());
        carInOutDto.setInImgUrl(IMGURL);
        carInOutDto.setOutNumUrl(NUMURL);
        carInOutDto.setDirect(ChannelDirectType.EXPROTATION.getType().shortValue());
        carInOutDto.setInTime(new Date());
        carInOutDto.setChannelId("daf80add93bf4116a7b1caa145887c45");
        carInOutDto.setChannelIp("172161083");
        carInOutDto.setChannelName("出");
        carInOutDto.setControlType(0);
        carInOutDto.setDevCode("222");
        carInOutDto.setMoney("9.59");
        carInOutDto.setOutCarPic("http://www.hdsc/parkinglotcompoment/imgUrl");
        carInOutDto.setOutNumUrl("http://www.hdsc/parkinglotcompoment/numberUrl");
        carInOutDto.setOutSluiceCode("333");
        carInOutDto.setOutTime(new Date());
        carInOutDto.setOwnerId("1001");
        carInOutDto.setOwnerName("xxxx");
        carInOutDto.setParkCode("HDZC00001");
        carInOutDto.setParkingLotId("9fc6b0874aca46da85dd6edb37c70a7b");
        carInOutDto.setRemark("xxxxxxx");
        carInOutDto.setRuleName("产权小车");
        carInOutDto.setTimeLength("2");

        ParkAccessCur parkAccessCur = new ParkAccessCur();
        parkAccessCur.setCardNumber("");
        parkAccessCur.setCarMode("0");
        parkAccessCur.setCarNum(CARNUM1);
        parkAccessCur.setCarportType((short) 0);
        parkAccessCur.setCarType((short) 0);
        parkAccessCur.setEnterMode((short) 0);
        parkAccessCur.setUuid("2");
        parkAccessCur.setInCameraCode("111");
        parkAccessCur.setInChannelId("daf80add93bf4116a7b1caa145887c45");
        parkAccessCur.setInImgUrl("http://www.hdsc/parkinglotcompoment/imgUrl");
        parkAccessCur.setInNumUrl("http://www.hdsc/parkinglotcompoment/numberUrl");
        parkAccessCur.setCreateTime(new Date());
        parkAccessCur.setUpdateTime(new Date());
        parkAccessCur.setNeedPay((short) 1);
        parkAccessCur.setOwnerId("1001");
        parkAccessCur.setParkCode("HD001");
        parkAccessCur.setParkPackageId("e8419ab98c28463fbbe07a584e56b3ce");
        parkAccessCur.setPayedMoney(20);
        parkAccessCur.setInMemo("xxxxxxx");
        carInOutDto.setParkAccessCur(parkAccessCur);

        ParkConsumeRecord parkConsumeRecord = new ParkConsumeRecord();
        parkConsumeRecord.setUuid(UuidUtil.generate());
        parkConsumeRecord.setCardNumber("");
        parkConsumeRecord.setCarNum(CARNUM1);
        parkConsumeRecord.setConsumeAmount(959);
        parkConsumeRecord.setCreateTime(new Date());
        parkConsumeRecord.setFeeAmount(959);
        parkConsumeRecord.setMemo("xxxxxx");
        parkConsumeRecord.setOperatorId("211");
        parkConsumeRecord.setOperatorName("xxxxx");
        parkConsumeRecord.setSerialNumber("654646213465132654");
        parkConsumeRecord.setTimeLength("2");
        parkConsumeRecord.setOwnerId("1001");
        carInOutDto.setParkConsumeRecord(parkConsumeRecord);
        return carInOutDto;
    }



}
