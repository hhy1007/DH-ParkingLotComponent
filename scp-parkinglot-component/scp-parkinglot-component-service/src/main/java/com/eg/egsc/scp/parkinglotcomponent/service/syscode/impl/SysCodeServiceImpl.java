/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.syscode.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.scp.parkinglotcomponent.condition.syscode.ParkSysCodeCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.syscode.ParkSysCodeDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.BaseFlag;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.SysCodeType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCode;
import com.eg.egsc.scp.parkinglotcomponent.service.syscode.SysCodeService;

/**
 * @Class Name SysCodeService
 * @Author huangyuhong
 * @Create In 2018年1月4日
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    protected ParkSysCodeDao parkSysCodeDao;// 数据库自定义操作接口

    private Map<String, String> carNumColorMap;// 车牌颜色

    private Map<String, String> carColorMap;// 车辆颜色

    private Map<String, String> carBrandMap;// 车辆品牌

    private Map<String, String> carModeMap;// 车型

    @Override
    public Map<String, String> getCarNumColorMap() {
        if (carNumColorMap != null) {
            return carNumColorMap;
        }
        ParkSysCodeCondition condition = new ParkSysCodeCondition();
        condition.setEnableFlag(BaseFlag.YES.getType().shortValue());
        condition.setTypeCode(SysCodeType.NUMCOLOR.getType());
        List<ParkSysCode> sysCodeList = parkSysCodeDao.selectList(condition);
        carNumColorMap = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(sysCodeList)) {
            for (ParkSysCode parkSysCode : sysCodeList) {
                carNumColorMap.put(parkSysCode.getItemCode(), parkSysCode.getItemName());
            }
        }

        return carNumColorMap;
    }

    @Override
    public Map<String, String> getCarColorMap() {
        if (carColorMap != null) {
            return carColorMap;
        }
        ParkSysCodeCondition condition = new ParkSysCodeCondition();
        condition.setEnableFlag(BaseFlag.YES.getType().shortValue());
        condition.setTypeCode(SysCodeType.COLOR.getType());
        List<ParkSysCode> sysCodeList = parkSysCodeDao.selectList(condition);
        carColorMap = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(sysCodeList)) {
            for (ParkSysCode parkSysCode : sysCodeList) {
                carColorMap.put(parkSysCode.getItemCode(), parkSysCode.getItemName());
            }
        }
        return carColorMap;
    }

    @Override
    public Map<String, String> getCarBrandMap() {
        if (carBrandMap != null) {
            return carBrandMap;
        }
        ParkSysCodeCondition condition = new ParkSysCodeCondition();
        condition.setEnableFlag(BaseFlag.YES.getType().shortValue());
        condition.setTypeCode(SysCodeType.BRAND.getType());
        List<ParkSysCode> sysCodeList = parkSysCodeDao.selectList(condition);
        carBrandMap = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(sysCodeList)) {
            for (ParkSysCode parkSysCode : sysCodeList) {
                carBrandMap.put(parkSysCode.getItemCode(), parkSysCode.getItemName());
            }
        }
        return carBrandMap;
    }

    @Override
    public Map<String, String> getCarModeMap() {
        if (carModeMap != null) {
            return carModeMap;
        }
        ParkSysCodeCondition condition = new ParkSysCodeCondition();
        condition.setEnableFlag(BaseFlag.YES.getType().shortValue());
        condition.setTypeCode(SysCodeType.MODE.getType());
        List<ParkSysCode> sysCodeList = parkSysCodeDao.selectList(condition);
        carModeMap = new LinkedHashMap<>();
        if (CollectionUtils.isNotEmpty(sysCodeList)) {
            for (ParkSysCode parkSysCode : sysCodeList) {
                carModeMap.put(parkSysCode.getItemCode(), parkSysCode.getItemName());
            }
        }
        return carModeMap;
    }

}
