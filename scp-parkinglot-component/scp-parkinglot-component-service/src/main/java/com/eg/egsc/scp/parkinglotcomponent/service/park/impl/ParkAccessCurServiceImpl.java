/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.park.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.access.AccessCurDao;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAccessCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCurCriteria;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessCurService;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;

@Service
public class ParkAccessCurServiceImpl implements ParkAccessCurService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkAccessCurMapper parkAccessCurMapper;

    @Autowired
    private AccessCurDao accessCurDao;

    @Override
    @Transactional
    public int insert(ParkAccessCur parkAccessCur) {
        insertValid(parkAccessCur);
        if (StringUtils.isBlank(parkAccessCur.getUuid())) {
            parkAccessCur.setUuid(UuidUtil.generate());
        }
        return parkAccessCurMapper.insert(parkAccessCur);
    }

    @Override
    @Transactional
    public int update(ParkAccessCur parkAccessCur) {
        updateValid(parkAccessCur);
        return parkAccessCurMapper.updateByPrimaryKey(parkAccessCur);
    }


    @Override
    public ParkAccessCur selectByPrimaryKey(String id) {
        if (StringUtils.isBlank(id)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        return parkAccessCurMapper.selectByPrimaryKey(id);
    }

    private void insertValid(ParkAccessCur parkAccessCur) {
        if (StringUtils.isBlank(parkAccessCur.getCarNum())
                || StringUtils.isBlank(parkAccessCur.getParkCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkAccessCur accessCur =
                selectByCarNumAndParkCode(parkAccessCur.getCarNum(), parkAccessCur.getParkCode());
        if (accessCur != null) {
            throw ExceptionFactory.createSysException(
                    ErrorCodeConstant.PARKINGLOT_PARKACCESSCUR_PLATE_NUMBER_REPEATE);
        }
    }

    private void updateValid(ParkAccessCur parkAccessCur) {
        if (StringUtils.isBlank(parkAccessCur.getUuid())
                || StringUtils.isBlank(parkAccessCur.getCarNum())
                || StringUtils.isBlank(parkAccessCur.getParkCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        ParkAccessCur accessCur =
                selectByCarNumAndParkCode(parkAccessCur.getCarNum(), parkAccessCur.getParkCode());
        if (accessCur == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
    }

    public ParkAccessCur selectByCarNumAndParkCode(String carNum, String parkCode) {
        ParkAccessCurCriteria duc = new ParkAccessCurCriteria();
        ParkAccessCurCriteria.Criteria ducc = duc.createCriteria();
        ducc.andCarNumEqualTo(carNum);
        ducc.andParkCodeEqualTo(parkCode);
        List<ParkAccessCur> list = parkAccessCurMapper.selectByExample(duc);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public AccessCur selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(String id) {
        return accessCurDao.selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(id);
    }

    @Override
    public Page<ParkAccessCur> selectPageList(AccessCurCondition condition) {
        PageRequest<AccessCurCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return accessCurDao.selectPageList(pageRequest);

    }

    @Override
    public int deleteByIds(List<String> ids) {
        logger.info("deleteByIds: {}", ids);
        return accessCurDao.deleteByIds(ids);
    }

    @Override
    public List<ParkAccessCur> selectList(AccessCurCondition condition) {
        return accessCurDao.selectList(condition);
    }

}
