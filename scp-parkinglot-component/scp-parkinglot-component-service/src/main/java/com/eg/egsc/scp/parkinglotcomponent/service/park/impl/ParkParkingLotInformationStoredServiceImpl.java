/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessHisDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.consume.ParkConsumeRecordDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.park.ParkParkingLotDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.OperateType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarStatus;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessHis;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.redis.RedisKey;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotInformationStoredService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.dto.ReBillingDto;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@Service
public class ParkParkingLotInformationStoredServiceImpl
        implements ParkParkingLotInformationStoredService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccessCurDao accessCurDao;// 在线车辆信息操作Dao

    @Autowired
    private ParkParkingLotDao parkParkingLotDao;// 停车场管理Dao

    @Autowired
    private AccessHisDao accessHisDao;// 停车历史记录表

    @Autowired
    private ParkConsumeRecordDao parkConsumeRecordDao;// 消费记录的Dao

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate; // redis模版

    @Override
    @Transactional
    public void storeCarInformation(CarInOutDto carInOutDto) {
        String channelId = carInOutDto.getChannelId();
        String carModeFromCarInOutDto = carInOutDto.getCarMode();
        String carNumFromCarInOutDto = carInOutDto.getCarNum();
        Object object = redisTemplate.opsForHash().get(RedisKey.KEY_CHANNEL_ID, channelId);
        ReBillingDto reBillingDto = null;
        if (object instanceof ReBillingDto) {
            reBillingDto = (ReBillingDto) object;
        }
        ParkAccessCur parkAccessCur = carInOutDto.getParkAccessCur();

        if (parkAccessCur == null && reBillingDto != null) {
            parkAccessCur = reBillingDto.getParkAccessCur();
        }

        String parkingLotId = carInOutDto.getParkingLotId();

        if (null == parkAccessCur) {// 如果没有在场记录
            executeNoCurStore(parkingLotId, carInOutDto, channelId);
            return;
        }
        String carNum = parkAccessCur.getCarNum();
        String enterMode = parkAccessCur.getCarMode();
        if (!enterMode.equals(carModeFromCarInOutDto) || !carNumFromCarInOutDto.equals(carNum)) {
            logger.info("parkinglot.common.different.parameters");
        }
        String accessCurId = parkAccessCur.getUuid();
        if (StringUtils.isNotBlank(accessCurId) && StringUtils.isNotBlank(parkingLotId)) {
            executeCurStore(accessCurId, parkingLotId, carInOutDto, channelId);
        }
    }

    @Override
    public void autoStoreCarInformation(CarInOutDto carInOutDto) {
        ParkAccessCur parkAccessCur = carInOutDto.getParkAccessCur();
        String parkingLotId = carInOutDto.getParkingLotId();
        if (null == parkAccessCur) {// 没有在线记录
            executeNoCurStore(parkingLotId, carInOutDto, "");
            return;
        }
        String accessCurId = parkAccessCur.getUuid();
        if (StringUtils.isNotBlank(accessCurId) && StringUtils.isNotBlank(parkingLotId)) {
            executeCurStore(accessCurId, parkingLotId, carInOutDto, "");
        }
    }

    /**
     * 无在场记录
     * 
     * @Methods Name executeNoCurStore
     * @Create In 2018年1月11日 By wangziqiang
     * @param parkingLotId
     * @param carInOutDto
     * @param channelId
     * @return Map<String,Object>
     */
    private void executeNoCurStore(String parkingLotId, CarInOutDto carInOutDto, String channelId) {
        // 更新停车场余位
        if (OperateType.MANUAL.getType().intValue() == carInOutDto.getControlType()) {
            parkParkingLotDao.updateParkingLotSelfReductionOrSelfAdd(parkingLotId, true);
        }
        // 插入历史记录表
        ParkAccessHis parkAccessHis = setParkAccessHis(carInOutDto);
        accessHisDao.getMapper().insert(parkAccessHis);
        // 插入消费记录
        ParkConsumeRecord parkConsumeRecord = carInOutDto.getParkConsumeRecord();
        if (parkConsumeRecord != null) {
            parkConsumeRecord.setAccessId(parkAccessHis.getUuid());
            this.parkConsumeRecordDao.insertConsumeRecord(parkConsumeRecord);
        }
        if (StringUtils.isNotBlank(channelId)) {
            this.redisTemplate.opsForHash().delete(RedisKey.KEY_CHANNEL_ID, channelId);
        }
        return;
    }

    /**
     * 设置历史进出类
     * 
     * @Methods Name setParkAccessHis
     * @Create In 2018年1月11日 By wangziqiang
     * @param carInOutDto
     * @return ParkAccessHis
     */
    private ParkAccessHis setParkAccessHis(CarInOutDto carInOutDto) {
        ParkAccessHis parkAccessHis = new ParkAccessHis();
        parkAccessHis.setUuid(UuidUtil.generate());
        int payedMoney = 0;
        if (null != carInOutDto.getParkAccessCur()) {
            parkAccessHis.setUuid(carInOutDto.getParkAccessCur().getUuid());
            if (null != carInOutDto.getParkAccessCur().getPayedMoney()) {
                payedMoney = carInOutDto.getParkAccessCur().getPayedMoney().intValue();
            }
        }
        parkAccessHis.setOutCarNum(carInOutDto.getCarNum());
        parkAccessHis.setOutChannelId(carInOutDto.getChannelId());
        parkAccessHis.setOutImgUrl(carInOutDto.getOutCarPic());
        parkAccessHis.setUpdateTime(carInOutDto.getOutTime());
        parkAccessHis.setOwnerId(carInOutDto.getOwnerId());
        parkAccessHis.setOutCameraCode(carInOutDto.getDevCode());
        parkAccessHis.setOutSluiceCode(carInOutDto.getOutSluiceCode());
        parkAccessHis.setCarStatus(CarStatus.ONLYOUTCAR.getStatus());
        parkAccessHis.setOutMemo(carInOutDto.getRemark());
        String money = carInOutDto.getMoney();
        if (StringUtils.isNotBlank(money)) {
            parkAccessHis.setPayedMoney((int) (Double.parseDouble(money) * 100) + payedMoney);
        } else {
            parkAccessHis.setPayedMoney(payedMoney);
        }
        parkAccessHis.setLastPayedTime(new Date());
        return parkAccessHis;
    }

    /**
     * 有在场记录执行
     * 
     * @Methods Name executeCurStore
     * @Create In 2018年1月11日 By wangziqiang
     * @param accessCurId
     * @param parkingLotId
     * @param carInOutDto
     * @param channelId
     * @return Map<String,Object>
     */
    private void executeCurStore(String accessCurId, String parkingLotId, CarInOutDto carInOutDto,
            String channelId) {
        // 删除在线车辆信息
        List<String> ids = new ArrayList<>(1);
        ids.add(accessCurId);
        accessCurDao.deleteByIds(ids);
        // 更新停车场余位
        parkParkingLotDao.updateParkingLotSelfReductionOrSelfAdd(parkingLotId, true);
        // 更新汽车的停车历史记录
        // 插入历史记录表
        ParkAccessHis parkAccessHis = setParkAccessHis(carInOutDto);
        accessHisDao.updateParkAccessHis(parkAccessHis);
        // 插入消费记录
        ParkConsumeRecord parkConsumeRecord = carInOutDto.getParkConsumeRecord();
        if (parkConsumeRecord != null) {
            parkConsumeRecord.setAccessId(accessCurId);
            this.parkConsumeRecordDao.insertConsumeRecord(parkConsumeRecord);
        }
        if (StringUtils.isNotBlank(channelId)) {
            this.redisTemplate.opsForHash().delete(RedisKey.KEY_CHANNEL_ID, channelId);
        }
    }
}
