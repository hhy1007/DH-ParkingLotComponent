/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.car.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.DeleteFlag;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.ParkCarType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarBatchOptDto;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

/**
 * 车辆管理业务层接口实现
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Service
public class CarServiceImpl implements CarService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkCarMapper parkCarMapper;// 数据库通用操作接口

    @Autowired
    protected CarMapper carMapper;// 数据库自定义SQL语句操作接口

    @Autowired
    protected CarDao carDao;// 数据库自定义操作接口

    @Override
    @Transactional
    public int insert(ParkCar car) {
        this.insertValid(car);
        car.setUuid(UuidUtil.generate());
        if (car.getCreateTime() == null) {
            car.setCreateTime(new Date());
        }
        if (car.getUpdateTime() == null) {
            car.setUpdateTime(car.getCreateTime());
        }
        if (car.getDeleteFlag() == null) {
            car.setDeleteFlag(DeleteFlag.NORMAL.getType());
        }
        return parkCarMapper.insert(car);
    }

    private void insertValid(ParkCar car) {
        if (StringUtils.isBlank(car.getCarNum())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkCar dbCar = carDao.selectCarByCarNum(car.getCarNum());
        if (dbCar != null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CAR_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    @Transactional
    public int update(ParkCar car) {
        this.updateValid(car);
        if (car.getUuid() == null) {
            return 0;
        }
        if (car.getUpdateTime() == null) {
            car.setUpdateTime(new Date());
        }
        return parkCarMapper.updateByPrimaryKey(car);
    }

    private void updateValid(ParkCar car) {
        if (StringUtils.isBlank(car.getUuid())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkCar dbCar = parkCarMapper.selectByPrimaryKey(car.getUuid());
        if (dbCar != null && !StringUtils.equals(car.getCarNum(), dbCar.getCarNum())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CAR_PLATE_NUMBER_REPEATE);
        }
    }

    @Override
    public int deleteByIds(List<String> ids) {
        logger.info("deleteByIds: {}", ids);
        return carDao.deleteByIds(ids);
    }

    @Override
    public Page<ParkCar> selectPageList(CarCondition condition) {
        PageRequest<CarCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return carDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkCar> selectList(CarCondition condition) {
        return carDao.selectList(condition);
    }

    @Override
    public ParkCar selectById(String id) {
        if (StringUtils.isBlank(id)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        return carDao.selectByPrimaryKey(id);
    }

    @Override
    public ParkCar selectByCarNum(String carNum) {
        if (StringUtils.isBlank(carNum)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        return carDao.selectCarByCarNum(carNum);
    }

    @Override
    public int updateStatus(ParkCar car) {
        return carMapper.updateCar(car);
    }

    @Override
    @Transactional
    public int updateStatusByids(CarBatchOptDto batchOptDto) {
        if (CollectionUtils.isEmpty(batchOptDto.getIds())) {
            return 0;
        }
        if (batchOptDto.getCarType().shortValue() != ParkCarType.COMMON.getType()) {
            if (batchOptDto.getValidStartTime() == null || batchOptDto.getValidEndTime() == null) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
            if (batchOptDto.getValidStartTime().getTime() > batchOptDto.getValidEndTime()
                    .getTime()) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
        }
        ParkCar parkCar = new ParkCar();
        parkCar.setValidStartTime(batchOptDto.getValidStartTime());
        parkCar.setValidEndTime(batchOptDto.getValidEndTime());
        parkCar.setListType(batchOptDto.getCarType());
        parkCar.setMemo(batchOptDto.getMemo());
        return carDao.updateStatusByids(parkCar, batchOptDto.getIds());
    }

    @Override
    @Transactional
    public int insertCarBatch(List<ParkCar> carList) {
        int insertRows = 0;
        int maxSize = 500;
        while (carList.size() > maxSize) {
            insertRows = validAndInsertBatch(carList, insertRows, maxSize);
            carList.subList(0, maxSize).clear();
        }
        insertRows = validAndInsertBatch(carList, insertRows, carList.size());
        return insertRows;
    }

    /**
     * 批量验证并且插入
     * 
     * @param carList
     * @param insertRows
     * @param maxSize
     * @return int
     */
    private int validAndInsertBatch(List<ParkCar> carList, int insertRows, int maxSize) {
        List<String> carNums = new ArrayList<>();
        HashSet<String> carNumMap = new HashSet<>();
        for (int i = 0; i < maxSize; i++) {
            ParkCar parkCar = carList.get(i);
            parkCar.setUuid(UuidUtil.generate());
            if (parkCar.getCreateTime() == null) {
                parkCar.setCreateTime(new Date());
            }
            if (parkCar.getUpdateTime() == null) {
                parkCar.setUpdateTime(parkCar.getCreateTime());
            }
            if (parkCar.getCarNum() == null) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
            if (parkCar.getDeleteFlag() == null) {
                parkCar.setDeleteFlag(DeleteFlag.NORMAL.getType());
            }
            carNums.add(parkCar.getCarNum());
            carNumMap.add(parkCar.getCarNum());
        }
        if (CollectionUtils.isNotEmpty(carMapper.selectCarByCarNums(carNums))
                || carNumMap.size() != maxSize) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_CAR_PLATE_NUMBER_REPEATE);
        }
        insertRows += carMapper.insertCarBatch(carList.subList(0, maxSize));
        return insertRows;
    }

}
