/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.parked.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.parked.ParkedCurDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.AuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmOccupyMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkedCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkedHisMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupy;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarportStateDto;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedCurService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车位功能 业务层接口
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
@Service
public class ParkedCurServiceImpl implements ParkedCurService {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 数据库通用操作接口
   */
  @Autowired
  private ParkParkedCurMapper parkParkedCurMapper;

  /**
   * 数据库通用操作接口
   */
  @Autowired
  private ParkParkedHisMapper parkParkedHisMapper;

  /**
   * 数据库自定义操作接口
   */
  @Autowired
  private ParkedCurDao parkedCurDao;

  /**
   * 车辆授权套餐操作接口
   */
  @Autowired
  private AuthPackageMapper authPackageMapper;

  /**
   * 车位占用预警操作接口
   */
  @Autowired
  private ParkAlarmOccupyMapper parkAlarmOccupyMapper;

  /**
   * 参数校验
   * 
   * @param parkParkedCur void
   */
  private void valid(ParkParkedCur parkParkedCur) {
    if (parkParkedCur == null) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    if (StringUtils.isBlank(parkParkedCur.getCarportCode())) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    if (StringUtils.isBlank(parkParkedCur.getCarNum())) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
  }

  /**
   * 调用更新地图停车状态接口
   * 
   * @param carportCode
   * @param carNum
   * @param newParkType void
   */
  private void carportStateChangeEvent(String carportCode, String carNum, short newParkType) {
    // 设置更新地图停车参数
    CarportStateDto carportStateDto = new CarportStateDto();
    carportStateDto.setCarportCode(carportCode);
    carportStateDto.setCarNum(carNum);
    carportStateDto.setParkType(newParkType);
    // 更新地图停车状态
    // integrationAppService.carportStateChangeEvent(carportStateDto);// 暂时还没有写实现方法,调用会报错
  }

  /**
   * 根据当前车位状态判断是否发出预警信息
   * 
   * @param carportCode
   * @param carNum
   * @param ownerId
   * @param parkParkedCur
   * @return int
   */
  private void isWarning(String carportCode, String carNum, String ownerId,
      ParkParkedCur parkParkedCur) {
    boolean flag = false;
    StringBuilder carNumFixed = new StringBuilder();
    Short alarmStatus = Constants.ALARM_STATUS_NO;
    // 判断是否有车位占用情况，授权套餐中车牌余当前车牌不一致，即为车位占用；
    // 设置查询授权车辆套餐参数
    ParkAuthPackageCondition condition = new ParkAuthPackageCondition();
    condition.setCarportCode(carportCode);
    List<AuthPackage> authPackageList = authPackageMapper.selectByExample(condition);
    for (AuthPackage authPackage : authPackageList) {
      List<ParkPackageCarRel> parkPackageCarRelList = authPackage.getParkPackageCarRel();
      for (ParkPackageCarRel parkPackageCarRel : parkPackageCarRelList) {
        carNumFixed.append(parkPackageCarRel.getCarNum());
        carNumFixed.append(",");
        if (!parkPackageCarRel.getCarNum().equals(carNum)) {
          flag = true;
          break;
        }
      }
    }
    if (flag) {
      ParkAlarmOccupy alarmRecord = new ParkAlarmOccupy();
      alarmStatus = Constants.ALARM_STATUS_YES;
      alarmRecord.setUuid(UuidUtil.generate());
      // 车位编码
      alarmRecord.setCarportCode(carportCode);
      // 固定车牌
      alarmRecord.setCarNumFixed(carNumFixed.toString());
      // 现停车牌
      alarmRecord.setCarNumCur(carNum);
      // 业主ID
      alarmRecord.setOwnerId(ownerId);
      // 预警状态
      alarmRecord.setAlarmState(alarmStatus);
      // 预警时间
      alarmRecord.setCreateTime(new Date());
      // 更新时间
      alarmRecord.setUpdateTime(new Date());
      // 保安派遣状态:0-未派遣,1-已派遣
      alarmRecord.setDispatchState(Constants.DISPATCH_STATE_NO);
      // 插入车位占用告警记录
      parkAlarmOccupyMapper.insert(alarmRecord);
    }
    // 车位占用报警
    parkParkedCur.setAlarmStatus(alarmStatus);
    // 更新车位实时状态表
    parkParkedCurMapper.updateByPrimaryKey(parkParkedCur);
    // 新增车位历史表数据
    ParkParkedHis parkParkedHis = new ParkParkedHis();
    BeanUtils.copyProperties(parkParkedCur, parkParkedHis);
    parkParkedHis.setUuid(UuidUtil.generate());
    parkParkedHisMapper.insert(parkParkedHis);
  }

  @Override
  @Transactional
  public void updateParkingStatus(ParkParkedCur parkParkedCur) {
    // 校验必填参数是否为空ha
    this.valid(parkParkedCur);
    // 车位编码
    String carportCode = parkParkedCur.getCarportCode();
    // 车牌号码
    String carNum = parkParkedCur.getCarNum();
    String ownerId = parkParkedCur.getOwnerId();

    // 判断是否有车位实时数据 :根据车位查询车位实时表，查询车位当前之前状态，如果车位实时表没有数据，新增一条数据；
    List<ParkParkedCur> parkedCurList = parkedCurDao.selectByCarportCode(carportCode);
    ParkParkedCur parkedCurData = null;
    if (null != parkedCurList && !parkedCurList.isEmpty()) {
      parkedCurData = parkedCurList.get(Constants.DEFAULT_INT_VALUE);
    }
    if (parkedCurData == null) {// 无
      parkParkedCur.setUuid(UuidUtil.generate());
      // 新增车位实时状态表
      parkParkedCurMapper.insert(parkParkedCur);
      // 新增车位历史表数据
      ParkParkedHis parkParkedHis = new ParkParkedHis();
      BeanUtils.copyProperties(parkParkedCur, parkParkedHis);
      parkParkedHis.setUuid(UuidUtil.generate());
      parkParkedHisMapper.insert(parkParkedHis);
    } else {// 有
      Short parkType = parkedCurData.getParkType();
      short newParkType = Constants.DEFAULT_SHORT_VALUE;
      // 0-无车；1-有车
      if (parkType == Constants.PARK_TYPE_YES) {
        newParkType = Constants.PARK_TYPE_NO;
      } else if (parkType == Constants.PARK_TYPE_NO) {
        newParkType = Constants.PARK_TYPE_YES;
      }
      this.carportStateChangeEvent(carportCode, carNum, newParkType);
      parkParkedCur.setParkType(newParkType);

      // 无车变有车，判断车位是否被占用
      if (parkType == Constants.PARK_TYPE_NO) {
        isWarning(carportCode, carNum, ownerId, parkParkedCur);
      } else {
        // 更新车位实时表的状态
        parkedCurDao.updateParkType(parkParkedCur);
        // 新增车位历史表数据
        ParkParkedHis parkParkedHis = new ParkParkedHis();
        BeanUtils.copyProperties(parkParkedCur, parkParkedHis);
        parkParkedHis.setUuid(UuidUtil.generate());
        parkParkedHisMapper.insert(parkParkedHis);
      }
    }
  }

  @Override
  public Integer updateLedCarport(ParkLedCarportRel parkLedCarportRel) {
    // 1、 组件增加定时器，定时计算诱导屏余位数
    // 2、 并将余位数通过物联网总线发送到诱导屏上
    return parkedCurDao.selectAreaIdleByCarportId(parkLedCarportRel);
  }

  @Override
  public Page<ParkParkedCur> selectPageList(ParkedCarportCondition condition) {
    PageRequest<ParkedCarportCondition> pageRequest = new PageRequest<>();
    pageRequest.setCurrentPage(condition.getCurrentPage());
    pageRequest.setPageSize(condition.getPageSize());
    pageRequest.setFilters(condition);
    return parkedCurDao.selectPageList(pageRequest);
  }

  @Override
  public List<ParkParkedCur> selectByCarportCode(String carportCode) {
    if (StringUtils.isBlank(carportCode)) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    return parkedCurDao.selectByCarportCode(carportCode);
  }

  @Override
  public List<ParkParkedCur> selectByCarNum(String carNum) {
    if (StringUtils.isBlank(carNum)) {
      throw ExceptionFactory.createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
    }
    return parkedCurDao.selectByCarNum(carNum);
  }
}
