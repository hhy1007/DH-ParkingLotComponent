/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.mdm.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.CarDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.ParkCarDevRelDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.service.mdm.MdmOperateService;
import com.eg.egsc.scp.parkinglotcomponent.util.Constants;

/**
 * 业主操作下发实现
 * 
 * @author huangyuhong
 * @since 2018年1月16日
 */
@Service
public class MdmOperateServiceImpl implements MdmOperateService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarDao carDao;
    
    @Autowired
    private ParkAuthPackageDao parkAuthPackageDao;
    
    @Autowired
    private ParkCarDevRelDao parkCarDevRelDao;


    @Override
    @Transactional
    public int deleteOwnerRel(BaseUserDto baseUserDto) {
        if (StringUtils.isBlank(baseUserDto.getUuid())) {
            return 0;
        }
        int result = 0;
        // 处理传多个id的情况
        List<String> ownerIds = new ArrayList<>();
        String ownerUUid = baseUserDto.getUuid();
        if (ownerUUid.length() > Constants.OWNER_ID_LENGTH.intValue()) {
            ownerIds = Arrays.asList(ownerUUid.split(","));
        } else {
            ownerIds.add(ownerUUid);
        }
        // 删除车辆相关的车辆下发
        List<ParkCar> carList = carDao.selectByOwnerIds(ownerIds);
        List<String> carNumList = new ArrayList<>();
        for (ParkCar parkCar : carList) {
            carNumList.add(parkCar.getCarNum());
        }
        if(CollectionUtils.isNotEmpty(carNumList)) {
            ParkCarDevRel carDevRel = new ParkCarDevRel();
            carDevRel.setOptType(CarDevRelOptType.DEL.getType());
            carDevRel.setStatus(CarDevRelStatus.SEND.getType());
            result+=parkCarDevRelDao.updateByCarNums(carDevRel, carNumList);
        }
        // 删除车辆
        result+=carDao.deleteByOwnerIds(ownerIds);
        // 删除套餐
        result+=parkAuthPackageDao.deleteByOwnerIds(ownerIds);
        return result;
    }

}
