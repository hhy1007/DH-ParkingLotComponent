/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.dev.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.dao.car.ParkCarDevRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.carport.ParkCarportRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.channel.ParkChannelRelDao;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.service.dev.DevService;

/**
 * 设备管理业务层实现
 * 
 * @author fengrongjun
 * @since 2018年1月23日
 */
@Service
public class DevServiceImpl implements DevService {

    @Autowired
    private ParkChannelRelDao parkChannelRelDao;
    
    @Autowired
    private ParkCarDevRelDao parkCarDevRelDao;
    
    @Autowired
    private ParkCarportRelDao parkCarportRelDao;
    
    @Override
    @Transactional
    public int deleteByDevCode(String devCode) {
        List<ParkChannelRel> parkChannelRelList = parkChannelRelDao.selectChannelRelByDevCode(devCode);
        int result = 0; //记录删除后返回影响的行数
        if(CollectionUtils.isNotEmpty(parkChannelRelList)) {
            result = parkChannelRelDao.deleteByDevCode(devCode);
        }
        List<ParkCarDevRel> parkCarDevRelList = parkCarDevRelDao.selectBydevCode(devCode);
        if(CollectionUtils.isNotEmpty(parkCarDevRelList)) {
            result = parkCarDevRelDao.deleteByDevCode(devCode);
        }
        List<ParkLedCarportRel> parkLedCarportRelList = parkCarportRelDao.selectLedCarportRelByLedCode(devCode);
        if(CollectionUtils.isNotEmpty(parkLedCarportRelList)) {
            result = parkCarportRelDao.deleteByLedCode(devCode);
        }
        return result;
    }

}
