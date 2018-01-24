/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.rule.FeeRuleCondition;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.ChargeInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FeeRuleDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.FreeTimeDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.NonPeakPeriodDto;
import com.eg.egsc.scp.parkinglotcomponent.dto.rule.PeakPeriodDto;
import com.eg.egsc.scp.parkinglotcomponent.enmus.rule.RuleType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkFeeRule;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.ParkFeeRuleService;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkFeeRuleServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private ParkFeeRuleService parkFeeRuleServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void selectByPrimaryKey() {
        ParkFeeRule parkFeeRule = parkFeeRuleServiceImpl.selectByPrimaryKey("23315656");
        logger.info("=== " + JSON.toJSONString(parkFeeRule));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void universalBillingInterface() throws ParseException {
        ParkAccessCur parkAccessCur = new ParkAccessCur();
        parkAccessCur.setUuid("3");
        Integer carType = 0;
        parkAccessCur.setCarportType((short) 0);
        Date endTime = DateUtil.stringToDate("2018-01-04 23:12:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        ResponseBillingDto responseBillingDto = null;
        try {
            responseBillingDto = parkFeeRuleServiceImpl.universalBillingInterface(parkAccessCur,
                    carType, endTime);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + JSON.toJSONString(responseBillingDto));
    }


    @Test
    @Transactional
    @Rollback(true)
    public void insertParkFeeRule() {

        List<ChargeInfoDto> chargeInfoDtoList = new ArrayList<>();
        FeeRuleDto feeRuleDto = new FeeRuleDto();
        feeRuleDto.setCreateTime(new Date());
        feeRuleDto.setCreateUser("1a");
        feeRuleDto.setMemo("1xc");
        feeRuleDto.setRuleName("收费规则按时1");
        feeRuleDto.setRuleType("time");

        ChargeInfoDto chargeInfoDto = new ChargeInfoDto();
        chargeInfoDto.setAvailable(Constants.FALSE);
        chargeInfoDto.setCarType(0);
        chargeInfoDto.setHighestFee(5800);

        FreeTimeDto freeTime = new FreeTimeDto();
        freeTime.setIsContain(Constants.FALSE);
        freeTime.setTime(60);
        chargeInfoDto.setFreeTime(freeTime);

        ChargeDetailDto chargeDetailDto = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto = new NonPeakPeriodDto();
        nonPeakPeriodDto.setCash(670);
        nonPeakPeriodDto.setEach(67);
        nonPeakPeriodDto.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto.setStartTime(Constants.ENDTIME);
        chargeDetailDto.setNonPeakPeriodDto(nonPeakPeriodDto);
        PeakPeriodDto peakPeriodDto = new PeakPeriodDto();
        peakPeriodDto.setCash(400);
        peakPeriodDto.setEach(50);
        peakPeriodDto.setEndTime(Constants.ENDTIME);
        peakPeriodDto.setStartTime(Constants.STARTTIME);
        chargeDetailDto.setPeakPeriodDto(peakPeriodDto);
        chargeInfoDto.setChargeDetailDto(chargeDetailDto);

        ChargeInfoDto chargeInfoDto1 = new ChargeInfoDto();
        chargeInfoDto1.setAvailable(Constants.TRUE);
        chargeInfoDto1.setCarType(1);
        chargeInfoDto1.setHighestFee(5900);

        FreeTimeDto freeTime1 = new FreeTimeDto();
        freeTime1.setIsContain(Constants.FALSE);
        freeTime1.setTime(50);
        chargeInfoDto1.setFreeTime(freeTime1);

        ChargeDetailDto chargeDetailDto1 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto1 = new NonPeakPeriodDto();
        nonPeakPeriodDto1.setCash(400);
        nonPeakPeriodDto1.setEach(50);
        nonPeakPeriodDto1.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto1.setStartTime(Constants.ENDTIME);
        chargeDetailDto1.setNonPeakPeriodDto(nonPeakPeriodDto1);
        PeakPeriodDto peakPeriodDto1 = new PeakPeriodDto();
        peakPeriodDto1.setCash(260);
        peakPeriodDto1.setEach(26);
        peakPeriodDto1.setEndTime(Constants.ENDTIME);
        peakPeriodDto1.setStartTime(Constants.STARTTIME);
        chargeDetailDto1.setPeakPeriodDto(peakPeriodDto1);
        chargeInfoDto1.setChargeDetailDto(chargeDetailDto1);

        ChargeInfoDto chargeInfoDto2 = new ChargeInfoDto();
        chargeInfoDto2.setAvailable(Constants.FALSE);
        chargeInfoDto2.setCarType(2);
        chargeInfoDto2.setHighestFee(4000);

        FreeTimeDto freeTime2 = new FreeTimeDto();
        freeTime2.setIsContain(Constants.FALSE);
        freeTime2.setTime(40);
        chargeInfoDto2.setFreeTime(freeTime2);

        ChargeDetailDto chargeDetailDto2 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto2 = new NonPeakPeriodDto();
        nonPeakPeriodDto2.setCash(700);
        nonPeakPeriodDto2.setEach(60);
        nonPeakPeriodDto2.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto2.setStartTime(Constants.ENDTIME);
        chargeDetailDto2.setNonPeakPeriodDto(nonPeakPeriodDto2);
        PeakPeriodDto peakPeriodDto2 = new PeakPeriodDto();
        peakPeriodDto2.setCash(300);
        peakPeriodDto2.setEach(30);
        peakPeriodDto2.setEndTime(Constants.ENDTIME);
        peakPeriodDto2.setStartTime(Constants.STARTTIME);
        chargeDetailDto2.setPeakPeriodDto(peakPeriodDto2);
        chargeInfoDto2.setChargeDetailDto(chargeDetailDto2);


        ChargeInfoDto chargeInfoDto3 = new ChargeInfoDto();
        chargeInfoDto3.setAvailable(Constants.TRUE);
        chargeInfoDto3.setCarType(3);
        chargeInfoDto3.setHighestFee(6000);

        FreeTimeDto freeTime3 = new FreeTimeDto();
        freeTime3.setIsContain(Constants.TRUE);
        freeTime3.setTime(20);
        chargeInfoDto3.setFreeTime(freeTime3);

        ChargeDetailDto chargeDetailDto3 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto3 = new NonPeakPeriodDto();
        nonPeakPeriodDto3.setCash(700);
        nonPeakPeriodDto3.setEach(70);
        nonPeakPeriodDto3.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto3.setStartTime(Constants.ENDTIME);
        chargeDetailDto3.setNonPeakPeriodDto(nonPeakPeriodDto3);
        PeakPeriodDto peakPeriodDto3 = new PeakPeriodDto();
        peakPeriodDto3.setCash(800);
        peakPeriodDto3.setEach(80);
        peakPeriodDto3.setEndTime(Constants.ENDTIME);
        peakPeriodDto3.setStartTime(Constants.STARTTIME);
        chargeDetailDto3.setPeakPeriodDto(peakPeriodDto3);
        chargeInfoDto3.setChargeDetailDto(chargeDetailDto3);

        chargeInfoDtoList.add(chargeInfoDto);
        chargeInfoDtoList.add(chargeInfoDto1);
        chargeInfoDtoList.add(chargeInfoDto2);
        chargeInfoDtoList.add(chargeInfoDto3);
        feeRuleDto.setChargeInfoDtoList(chargeInfoDtoList);
        int result = 0;
        try {
            result = parkFeeRuleServiceImpl.insert(feeRuleDto);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateParkFeeRule() {
        List<ChargeInfoDto> chargeInfoDtoList = new ArrayList<>();
        FeeRuleDto feeRuleDto5 = new FeeRuleDto();
        feeRuleDto5.setUuid("0cc39cb465b348ffb7d77b59def6ada7");
        feeRuleDto5.setCreateTime(new Date());
        feeRuleDto5.setCreateUser("1");
        feeRuleDto5.setMemo("1");
        feeRuleDto5.setRuleName("收费规则按时4");
        feeRuleDto5.setRuleType("interval");

        ChargeInfoDto chargeInfoDto5 = new ChargeInfoDto();
        chargeInfoDto5.setAvailable(Constants.FALSE);
        chargeInfoDto5.setCarType(0);
        chargeInfoDto5.setHighestFee(500);

        FreeTimeDto freeTime5 = new FreeTimeDto();
        freeTime5.setIsContain(Constants.FALSE);
        freeTime5.setTime(60);
        chargeInfoDto5.setFreeTime(freeTime5);

        ChargeDetailDto chargeDetailDto5 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto5 = new NonPeakPeriodDto();
        nonPeakPeriodDto5.setCash(330);
        nonPeakPeriodDto5.setEach(55);
        nonPeakPeriodDto5.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto5.setStartTime(Constants.ENDTIME);
        chargeDetailDto5.setNonPeakPeriodDto(nonPeakPeriodDto5);
        PeakPeriodDto peakPeriodDto5 = new PeakPeriodDto();
        peakPeriodDto5.setCash(440);
        peakPeriodDto5.setEach(56);
        peakPeriodDto5.setEndTime(Constants.ENDTIME);
        peakPeriodDto5.setStartTime(Constants.STARTTIME);
        chargeDetailDto5.setPeakPeriodDto(peakPeriodDto5);
        chargeInfoDto5.setChargeDetailDto(chargeDetailDto5);

        ChargeInfoDto chargeInfoDto6 = new ChargeInfoDto();
        chargeInfoDto6.setAvailable(Constants.FALSE);
        chargeInfoDto6.setCarType(1);
        chargeInfoDto6.setHighestFee(560);

        FreeTimeDto freeTime1 = new FreeTimeDto();
        freeTime1.setIsContain(Constants.TRUE);
        freeTime1.setTime(50);
        chargeInfoDto6.setFreeTime(freeTime1);

        ChargeDetailDto chargeDetailDto6 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto6 = new NonPeakPeriodDto();
        nonPeakPeriodDto6.setCash(470);
        nonPeakPeriodDto6.setEach(57);
        nonPeakPeriodDto6.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto6.setStartTime(Constants.ENDTIME);
        chargeDetailDto6.setNonPeakPeriodDto(nonPeakPeriodDto6);
        PeakPeriodDto peakPeriodDto6 = new PeakPeriodDto();
        peakPeriodDto6.setCash(360);
        peakPeriodDto6.setEach(37);
        peakPeriodDto6.setEndTime(Constants.ENDTIME);
        peakPeriodDto6.setStartTime(Constants.STARTTIME);
        chargeDetailDto6.setPeakPeriodDto(peakPeriodDto6);
        chargeInfoDto6.setChargeDetailDto(chargeDetailDto6);

        ChargeInfoDto chargeInfoDto7 = new ChargeInfoDto();
        chargeInfoDto7.setAvailable(Constants.TRUE);
        chargeInfoDto7.setCarType(2);
        chargeInfoDto7.setHighestFee(490);

        FreeTimeDto freeTime7 = new FreeTimeDto();
        freeTime7.setIsContain(Constants.TRUE);
        freeTime7.setTime(40);
        chargeInfoDto7.setFreeTime(freeTime7);

        ChargeDetailDto chargeDetailDto7 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto7 = new NonPeakPeriodDto();
        nonPeakPeriodDto7.setCash(420);
        nonPeakPeriodDto7.setEach(52);
        nonPeakPeriodDto7.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto7.setStartTime(Constants.ENDTIME);
        chargeDetailDto7.setNonPeakPeriodDto(nonPeakPeriodDto7);
        PeakPeriodDto peakPeriodDto7 = new PeakPeriodDto();
        peakPeriodDto7.setCash(330);
        peakPeriodDto7.setEach(53);
        peakPeriodDto7.setEndTime(Constants.ENDTIME);
        peakPeriodDto7.setStartTime(Constants.STARTTIME);
        chargeDetailDto7.setPeakPeriodDto(peakPeriodDto7);
        chargeInfoDto7.setChargeDetailDto(chargeDetailDto7);


        ChargeInfoDto chargeInfoDto8 = new ChargeInfoDto();
        chargeInfoDto8.setAvailable(Constants.TRUE);
        chargeInfoDto8.setCarType(3);
        chargeInfoDto8.setHighestFee(550);

        FreeTimeDto freeTime8 = new FreeTimeDto();
        freeTime8.setIsContain(Constants.FALSE);
        freeTime8.setTime(30);
        chargeInfoDto8.setFreeTime(freeTime8);

        ChargeDetailDto chargeDetailDto8 = new ChargeDetailDto();
        NonPeakPeriodDto nonPeakPeriodDto8 = new NonPeakPeriodDto();
        nonPeakPeriodDto8.setCash(560);
        nonPeakPeriodDto8.setEach(56);
        nonPeakPeriodDto8.setEndTime(Constants.STARTTIME);
        nonPeakPeriodDto8.setStartTime(Constants.ENDTIME);
        chargeDetailDto8.setNonPeakPeriodDto(nonPeakPeriodDto8);
        PeakPeriodDto peakPeriodDto8 = new PeakPeriodDto();
        peakPeriodDto8.setCash(550);
        peakPeriodDto8.setEach(51);
        peakPeriodDto8.setEndTime(Constants.ENDTIME);
        peakPeriodDto8.setStartTime(Constants.STARTTIME);
        chargeDetailDto8.setPeakPeriodDto(peakPeriodDto8);
        chargeInfoDto8.setChargeDetailDto(chargeDetailDto8);

        chargeInfoDtoList.add(chargeInfoDto5);
        chargeInfoDtoList.add(chargeInfoDto6);
        chargeInfoDtoList.add(chargeInfoDto7);
        chargeInfoDtoList.add(chargeInfoDto8);
        feeRuleDto5.setChargeInfoDtoList(chargeInfoDtoList);
        int result = 0;
        try {
            result = parkFeeRuleServiceImpl.update(feeRuleDto5);
        } catch (Exception e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchParkFeeRules() {
        List<String> ids = new ArrayList<>();
        ids.add("11");
        int result = parkFeeRuleServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        FeeRuleCondition condition = new FeeRuleCondition();
        condition.setPageSize(10);
        condition.setCurrentPage(1);
        condition.setRuleName("11");
        Page<ParkFeeRule> page = parkFeeRuleServiceImpl.selectPageList(condition);
        logger.info("=== " + JSON.toJSONString(page));
    }

    private static String detail =
            "[{\"available\":\"false\",\"carType\":0,\"chargeDetailDto\":{\"nonPeakPeriodDto\":"
                    + "{\"cash\":300,\"each\":50,\"endTime\":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":400,\"each\":50,"
                    + "\"endTime\":\"21:00\",\"startTime\":\"7:00\"}},\"freeTime\":{\"isContain\":\"false\",\"time\":60},"
                    + "\"highestFee\":5000},{\"available\":"
                    + "\"true\",\"carType\":1,\"chargeDetailDto\":{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,"
                    + "\"endTime\":\"7:00\",\"startTime\":\"21:00\"},"
                    + "\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\",\"startTime\":\"7:00\"}},"
                    + "\"freeTime\":{\"isContain\":\"false\","
                    + "\"time\":50},\"highestFee\":5000},{\"available\":\"false\",\"carType\":2,\"chargeDetailDto\":"
                    + "{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,\"endTime\""
                    + ":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\","
                    + "\"startTime\":\"7:00\"}},\"freeTime\":{\"isContain\":"
                    + "\"false\",\"time\":40},\"highestFee\":4000},{\"available\":\"true\",\"carType\":3,\"chargeDetailDto\":"
                    + "{\"nonPeakPeriodDto\":{\"cash\":400,\"each\":50,\"endTime\""
                    + ":\"7:00\",\"startTime\":\"21:00\"},\"peakPeriodDto\":{\"cash\":300,\"each\":50,\"endTime\":\"21:00\","
                    + "\"startTime\":\"7:00\"}},\"freeTime\":"
                    + "{\"isContain\":\"true\",\"time\":30},\"highestFee\":4000}]";

    @Test
    @Transactional
    @Rollback(true)
    public void computationsFeeRule() {
        Date startTime = DateUtil.stringToDate("2108-01-15 16:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date endTime = DateUtil.stringToDate("2108-01-15 18:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        int carType = 0;
        FeeRuleDto feeRuleDto = new FeeRuleDto();
        feeRuleDto.setDetail(detail);
        feeRuleDto.setRuleType(RuleType.INTERVAL.getType());
        String sumMoney = null;
        try {
            sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(startTime, endTime, carType,
                    feeRuleDto);
        } catch (ParseException e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + sumMoney);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void computationsFeeRule1() {
        Date startTime1 =
                DateUtil.stringToDate("2108-01-17 19:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date endTime1 = DateUtil.stringToDate("2108-01-17 21:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        int carType1 = 0;
        FeeRuleDto feeRuleDto1 = new FeeRuleDto();
        feeRuleDto1.setDetail(detail);
        feeRuleDto1.setRuleType(RuleType.INTERVAL.getType());
        String sumMoney = null;
        try {
            sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(startTime1, endTime1, carType1,
                    feeRuleDto1);
        } catch (ParseException e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + sumMoney);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void computationsFeeRule4() {
        Date startTime3 =
                DateUtil.stringToDate("2108-01-17 20:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date endTime3 = DateUtil.stringToDate("2108-01-18 07:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        int carType3 = 0;
        FeeRuleDto feeRuleDto3 = new FeeRuleDto();
        feeRuleDto3.setDetail(detail);
        feeRuleDto3.setRuleType(RuleType.INTERVAL.getType());
        String sumMoney = null;
        try {
            sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(startTime3, endTime3, carType3,
                    feeRuleDto3);
        } catch (ParseException e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + sumMoney);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void computationsFeeRule5() {
        Date startTime5 =
                DateUtil.stringToDate("2108-01-17 06:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date endTime5 = DateUtil.stringToDate("2108-01-18 01:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        int carType5 = 0;
        FeeRuleDto feeRuleDto5 = new FeeRuleDto();
        feeRuleDto5.setDetail(detail);
        feeRuleDto5.setRuleType(RuleType.INTERVAL.getType());
        String sumMoney = null;
        try {
            sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(startTime5, endTime5, carType5,
                    feeRuleDto5);
        } catch (ParseException e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + sumMoney);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void computationsFeeRule6() {
        Date startTime6 =
                DateUtil.stringToDate("2108-01-17 06:36:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        Date endTime6 = DateUtil.stringToDate("2108-01-17 09:56:00", DateUtil.YYYY_MM_DD_HH_MM_SS);
        int carType6 = 0;
        FeeRuleDto feeRuleDto6 = new FeeRuleDto();
        feeRuleDto6.setDetail(detail);
        feeRuleDto6.setRuleType(RuleType.INTERVAL.getType());
        String sumMoney = null;
        try {
            sumMoney = parkFeeRuleServiceImpl.computationsFeeRule(startTime6, endTime6, carType6,
                    feeRuleDto6);
        } catch (ParseException e) {
            logger.info("=== " + e.getMessage());
        }
        logger.info("=== " + sumMoney);
    }
}
