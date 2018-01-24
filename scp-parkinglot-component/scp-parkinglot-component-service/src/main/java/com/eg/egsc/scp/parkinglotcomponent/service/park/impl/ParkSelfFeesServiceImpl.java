/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCurCriteria;
import com.eg.egsc.scp.parkinglotcomponent.service.car.impl.CarEnterParkingLotServiceImpl;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkSelfFeesService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReFeesDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.ResponseBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.util.DateUtil;

/**
 * @Class Name ParkSelfFeesSerivce
 * @Author wangziqiang
 * @Create In 2018年1月9日
 */
@Service
public class ParkSelfFeesServiceImpl implements ParkSelfFeesService {

    @Autowired
    private AccessCurDao accessCurDao;// 在场记录DAO
    @Autowired
    private ParkIcExitParkingLotServiceImpl parkIcExitParkingLotServiceImpl;// 通过ic出场
    @Autowired
    private CarEnterParkingLotServiceImpl carEnterParkingLotServiceImpl;// 进场逻辑

    @Override
    public ReFeesDto demandFees(String carNum, String cardNumber, String nowTime) {
        Date endTime = DateUtil.stringToDate(nowTime, DateUtil.YYYY_MM_DD_HH_MM_SS);
        ReFeesDto reFeesDto = new ReFeesDto();
        List<ParkAccessCur> list = getParkAccessList(carNum, cardNumber);
        if (CollectionUtils.isNotEmpty(list)) {
            ParkAccessCur parkAccessCur = list.get(0);
            ResponseBillingDto responseBillingDto =
                    parkIcExitParkingLotServiceImpl.markCharging(parkAccessCur, endTime);
            String money = "0.00";
            reFeesDto.setTheStopTime(0);
            if (null != responseBillingDto) {
                money = responseBillingDto.getCharges();
                reFeesDto.setTheStopTime(responseBillingDto.getTheStopTime());
            }
            reFeesDto.setMoney(money);
            String ownerId = parkAccessCur.getOwnerId();
            if (StringUtils.isNotBlank(ownerId)) {
                String ownerName = carEnterParkingLotServiceImpl.getOwnerNameById(ownerId);
                reFeesDto.setOwnerName(ownerName);
            }
            return reFeesDto;
        }
        return null;
    }

    @Override
    public int updateParkAccessCur(String carNum, String cardNumber, String money) {
        ParkAccessCur record = new ParkAccessCur();
        if (StringUtils.isNotBlank(money)) {
            double needMoney = Double.parseDouble(money) * 100;

            if (StringUtils.isBlank(carNum) && StringUtils.isBlank(cardNumber)) {
                return 0;
            }
            List<ParkAccessCur> parkAccessList = getParkAccessList(carNum, cardNumber);
            if (CollectionUtils.isNotEmpty(parkAccessList)) {
                ParkAccessCur parkAccessCur = parkAccessList.get(0);
                Integer payedMoney = parkAccessCur.getPayedMoney();
                if (null == payedMoney) {// 前面没付钱
                    record.setPayedMoney((int) needMoney);
                } else {// 有付过钱
                    int needMoneyInt = (int) needMoney;
                    int payedMoneyInt = payedMoney.intValue();
                    int payedSum = needMoneyInt + payedMoneyInt;
                    record.setPayedMoney(payedSum);
                }
            }
            Date now = new Date();
            record.setUpdateTime(now);
        }


        AccessCurCondition condition = new AccessCurCondition();
        condition.setCardNumber(cardNumber);
        condition.setCarNum(carNum);
        ParkAccessCurCriteria example = accessCurDao.getBaseCriteria(condition);
        if (StringUtils.isNotBlank(carNum)
                || StringUtils.isNotBlank(cardNumber) && StringUtils.isNotBlank(money)) {
            return accessCurDao.getMapper().updateByExampleSelective(record, example);

        }
        return 0;
    }

    /**
     * 得到在场车辆信息
     * 
     * @Methods Name getParkAccessList
     * @Create In 2018年1月18日 By wangziqiang
     * @param carNum
     * @param cardNumber
     * @return List<ParkAccessCur>
     */
    private List<ParkAccessCur> getParkAccessList(String carNum, String cardNumber) {
        AccessCurCondition condition = new AccessCurCondition();
        condition.setCarNum(carNum);
        condition.setCardNumber(cardNumber);
        return accessCurDao.selectList(condition);
    }
}
