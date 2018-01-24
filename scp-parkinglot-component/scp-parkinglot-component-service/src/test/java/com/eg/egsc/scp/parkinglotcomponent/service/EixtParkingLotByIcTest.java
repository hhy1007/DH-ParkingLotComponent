/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

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
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkIcExitParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.IcInformationDto;

/**
 * 通过IC卡进行出场流程
 * 
 * @Class Name TestEixtParkingLotByIc
 * @Author wangziqiang
 * @Create In 2018年1月8日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class EixtParkingLotByIcTest {
    protected final Logger logger = LoggerFactory.getLogger(EixtParkingLotByIcTest.class);

    @Autowired
    private ParkIcExitParkingLotService parkIcExitParkingLotServiceImpl;

    /**
     * @filed 卡号2
     */
    private static final String CARNUMBER2 = "123460";
    /**
     * @filed 卡号3
     */
    private static final String CARNUMBER3 = "123461";
    /**
     * @filed 卡号5
     */
    private static final String CARNUMBER5 = "123465";

    /**
     * @filed 卡号6
     */
    private static final String CARNUMBER6 = "123457";
    
    /**
     * @filed 卡号4
     */
    private static final String CARNUMBER4 = "123466";
    /**
     * @filed 卡号7
     */
    private static final String CARNUMBER7 = "123467";
    
    /**
     * @filed 设备编号
     */
    private static final String DEVCODE = "222";

    /**
     * @filed 开闸类型 - 自动
     */
    private static final int OPERATETYPE1 = 0;

    /**
     * @filed 开闸类型 - 手动
     */
    private static final int OPERATETYPE2 = 1;

    /**
     * @filed 车主1
     */
    private static final String OWNERID1 = "1001";

    /**
     * @filed 车主2
     */
    private static final String OWNERID2 = "1002";

    /**
     * @filed 车主3
     */
    private static final String OWNERID3 = "1004";

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 自动开杆模式 有在场记录
     * 
     * @Methods Name testEixtParkingLotByIc1
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc1() {// T
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER6, DEVCODE, OPERATETYPE1, OWNERID1);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

    }

    /**
     * 
     * @Methods Name getIcInformationDto
     * @Create In 2018年1月15日 By wangziqiang
     * @param cardNumber
     * @param devCode
     * @param operateType
     * @param ownerId
     * @return IcInformationDto
     */
    private IcInformationDto getIcInformationDto(final String cardNumber, String devCode,
            int operateType, String ownerId) {
        IcInformationDto icInformationDto = new IcInformationDto();
        icInformationDto.setCardNumber(cardNumber);
        icInformationDto.setDevCode(devCode);
        icInformationDto.setOperateType(operateType);
        icInformationDto.setOwnerId(ownerId);
        return icInformationDto;
    }


    @Test
    @Transactional
    @Rollback(true)
    /**
     * 自动开杆模式 无在场记录
     * 
     * @Methods Name testEixtParkingLotByIc2
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc2() {// T
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER4, DEVCODE, OPERATETYPE1, OWNERID1);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 手动开杆模式 有在场记录 套餐无效
     * 
     * @Methods Name testEixtParkingLotByIc3
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc3() {// T
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER2, DEVCODE, OPERATETYPE2, OWNERID3);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 手动开杆模式 有在场记录 套餐有效
     * 
     * @Methods Name testEixtParkingLotByIc4
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc4() {// T
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER3, DEVCODE, OPERATETYPE2, OWNERID1);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 手动开杆模式 无在场记录 有车主id 套餐有效
     * 
     * @Methods Name testEixtParkingLotByIc5
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc5() {// T
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER5, DEVCODE, OPERATETYPE2, OWNERID2);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 手动开杆模式 无在场记录 有车主id 套餐无效
     * 
     * @Methods Name testEixtParkingLotByIc6
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc6() {
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER4, DEVCODE, OPERATETYPE2, OWNERID1);
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    /**
     * 手动开杆模式 无在场记录 无车主id
     * 
     * @Methods Name testEixtParkingLotByIc7
     * @Create In 2018年1月15日 By wangziqiang void
     */
    public void testEixtParkingLotByIc7() {
        IcInformationDto icInformationDto =
                getIcInformationDto(CARNUMBER7, DEVCODE, OPERATETYPE2, "");
        try {
            parkIcExitParkingLotServiceImpl.exitParkParkingByIc(icInformationDto);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
