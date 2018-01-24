/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.authpackage.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.mdm.component.client.UserClient;
import com.eg.egsc.scp.mdm.component.dto.BaseUserDto;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarDevRelConditon;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkPackageCarRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkPackageParkRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.car.ParkCarDevRelDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.rule.ParkRuleDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.DeleteFlag;
import com.eg.egsc.scp.parkinglotcomponent.enmus.authpackage.PackageState;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelOptType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarDevRelStatus;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarListType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.channel.ChannelDevType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.AuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.car.CarDevRelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.ChannelMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.ChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAuthPackageMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarDevRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageParkRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkRule;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.ParkAuthPackageService;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.dto.AuthPackageDto;
import com.eg.egsc.scp.parkinglotcomponent.service.rule.dto.RuleDetailDto;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;


/**
 * 授权套餐业务接口实现
 * 
 * @author huangyuhong
 * @since 2018年1月12日
 */
@Service
public class ParkAuthPackageServiceImpl implements ParkAuthPackageService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkAuthPackageMapper parkAuthPackageMapper;// 数据库通用操作接口

    @Autowired
    private AuthPackageMapper authPackageMapper;// 数据库自定义操作接口

    @Autowired
    protected ParkAuthPackageDao parkAuthPackageDao;// 数据库自定义操作接口

    @Autowired
    protected ParkPackageCarRelDao packageCarRelDao;// 数据库自定义操作接口

    @Autowired
    protected ParkPackageParkRelDao packageParkRelDao;// 数据库自定义操作接口

    @Autowired
    protected UserClient userClientImpl;// 主数据用户接口

    @Autowired
    protected ParkRuleDao parkRuleDao;// 进出规则通用接口

    @Autowired
    protected ParkCarDevRelDao parkCarDevRelDao;// 车辆下发设备通用接口

    @Autowired
    protected CarDevRelMapper carDevRelMapper;// 数据库自定义SQL语句操作接口

    @Autowired
    protected ChannelMapper channelMapper;// 通道自定义操作接口



    @Override
    @Transactional
    public int insert(AuthPackage authPackage) {
        ParkAuthPackage parkAuthPackage = new ParkAuthPackage();
        BeanUtils.copyProperties(authPackage, parkAuthPackage);
        this.insertValid(parkAuthPackage);
        parkAuthPackage.setUuid(UuidUtil.generate());
        if (parkAuthPackage.getCreateTime() == null) {
            parkAuthPackage.setCreateTime(new Date());
        }
        if (parkAuthPackage.getUpdateTime() == null) {
            parkAuthPackage.setUpdateTime(parkAuthPackage.getCreateTime());
        }
        if (parkAuthPackage.getDeleteFlag() == null) {
            parkAuthPackage.setDeleteFlag(DeleteFlag.NORMAL.getType());
        }
        if (parkAuthPackage.getState() == null) {
            parkAuthPackage.setState(PackageState.NOMALSTATE.getType());
        }
        int result = parkAuthPackageMapper.insert(parkAuthPackage);
        List<ParkPackageCarRel> packageCarRels = authPackage.getParkPackageCarRel();
        if (CollectionUtils.isNotEmpty(packageCarRels)) {
            for (ParkPackageCarRel carRel : packageCarRels) {
                carRel.setPackageId(parkAuthPackage.getUuid());
            }
            packageCarRelDao.insertPackageCarRelBatch(packageCarRels);
        }
        List<ParkPackageParkRel> packageParkRels = authPackage.getParkPackageParkRel();
        if (CollectionUtils.isNotEmpty(packageParkRels)) {
            for (ParkPackageParkRel parkRel : authPackage.getParkPackageParkRel()) {
                parkRel.setPackageId(parkAuthPackage.getUuid());
            }
            packageParkRelDao.insertPackageParkRelBatch(packageParkRels);
        }
        return result;
    }

    @Override
    @Transactional
    public int update(AuthPackage authPackage) {
        ParkAuthPackage parkAuthPackage = new ParkAuthPackage();
        parkAuthPackage.setUuid(authPackage.getId());
        BeanUtils.copyProperties(authPackage, parkAuthPackage);
        // 验证基本参数
        AuthPackage oldPackage = this.updateValid(parkAuthPackage);
        List<String> newCarNums = new ArrayList<>();
        List<String> newParkCodes = new ArrayList<>();
        // 删除套餐绑定的车牌和车场号
        packageCarRelDao.deleteByParkPackageId(parkAuthPackage.getUuid());
        packageParkRelDao.deleteByParkPackageId(parkAuthPackage.getUuid());
        // 修改套餐新增套餐绑定的车牌和车场号
        int result = parkAuthPackageMapper.updateByPrimaryKeySelective(parkAuthPackage);
        List<ParkPackageCarRel> packageCarRels = authPackage.getParkPackageCarRel();
        if (CollectionUtils.isNotEmpty(packageCarRels)) {
            for (ParkPackageCarRel carRel : authPackage.getParkPackageCarRel()) {
                carRel.setPackageId(parkAuthPackage.getUuid());
                newCarNums.add(carRel.getCarNum());
            }
            packageCarRelDao.insertPackageCarRelBatch(packageCarRels);
        }
        List<ParkPackageParkRel> packageParkRels = authPackage.getParkPackageParkRel();
        if (CollectionUtils.isNotEmpty(packageParkRels)) {
            for (ParkPackageParkRel parkRel : authPackage.getParkPackageParkRel()) {
                parkRel.setPackageId(parkAuthPackage.getUuid());
                newParkCodes.add(parkRel.getParkCode());
            }
            packageParkRelDao.insertPackageParkRelBatch(packageParkRels);
        }
        if (oldPackage.getValidEndTime() == null) {
            return result;
        }
        // 车牌,卡片下发授权修改
        List<String> oldCarNums = new ArrayList<>();
        List<String> oldParkCodes = new ArrayList<>();
        List<ParkPackageCarRel> oldCarRels = oldPackage.getParkPackageCarRel();
        List<ParkPackageParkRel> oldParkRels = oldPackage.getParkPackageParkRel();
        if (CollectionUtils.isNotEmpty(oldCarRels)) {
            for (ParkPackageCarRel CarRel : oldCarRels) {
                oldCarNums.add(CarRel.getCarNum());
            }
        }
        if (CollectionUtils.isNotEmpty(oldParkRels)) {
            for (ParkPackageParkRel ParkRel : oldParkRels) {
                oldParkCodes.add(ParkRel.getParkCode());
            }
        }
        Map<String, List<String>> info = new HashMap<>();
        info.put("oldCarNums", oldCarNums);
        info.put("oldParkCodes", oldParkCodes);
        info.put("newCarNums", newCarNums);
        info.put("newParkCodes", newParkCodes);
        this.updateCarDevRel(info);
        return result;
    }

    /**
     * 更新授权套餐验证
     * 
     * @param authPackage
     * @param parkAuthPackage
     * @return AuthPackage
     */
    private AuthPackage updateValid(ParkAuthPackage parkAuthPackage) {
        if (StringUtils.isBlank(parkAuthPackage.getOwnerId())
                || parkAuthPackage.getCarportType() == null || parkAuthPackage.getUuid() == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        parkAuthPackage.setUpdateTime(new Date());
        AuthPackage oldPackage = parkAuthPackageDao.selectByPrimaryKey(parkAuthPackage.getUuid());
        if (oldPackage == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        if (StringUtils.isNotBlank(parkAuthPackage.getCarportCode())
                && !oldPackage.getCarportCode().equals(parkAuthPackage.getCarportCode())) {
            List<ParkAuthPackage> carportCoderesult = parkAuthPackageDao
                    .selectParkAuthPackageByCarportCode(parkAuthPackage.getCarportCode());
            if (CollectionUtils.isNotEmpty(carportCoderesult)) {
                throw ExceptionFactory.createSysException(
                        ErrorCodeConstant.PARKINGLOT_AUTHPACKAGE_CARPORT_OCCPIED);
            }
        }
        return oldPackage;
    }


    @Override
    @Transactional
    public int deleteByIds(List<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            // 车辆下发授权删除
            List<AuthPackage> packageList = authPackageMapper.selectByIds(ids);
            List<CarDevRelConditon> delCarDevRels = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(packageList)) {
                ParkCarDevRel devRel = new ParkCarDevRel();
                devRel.setOptType(CarDevRelOptType.DEL.getType());
                devRel.setStatus(CarDevRelStatus.SEND.getType());
                this.setCarDevRelCondition(packageList, delCarDevRels);
                if (CollectionUtils.isNotEmpty(delCarDevRels)) {
                    carDevRelMapper.updateStatusByCarNumsAndParkCodes(devRel, delCarDevRels);
                }
            }
            return parkAuthPackageDao.deleteByIds(ids);
        } else {
            return 0;
        }
    }

    /**
     * 通过授权套餐设置下发表修改条件
     * 
     * @param packageList
     * @param delCarDevRels void
     */
    private void setCarDevRelCondition(List<AuthPackage> packageList,
            List<CarDevRelConditon> delCarDevRels) {
        for (AuthPackage authPackage : packageList) {
            if (CollectionUtils.isNotEmpty(authPackage.getParkPackageParkRel())) {
                if (CollectionUtils.isNotEmpty(authPackage.getParkPackageCarRel())) {
                    List<String> carNums = new ArrayList<>();
                    for (ParkPackageCarRel packageCarRel : authPackage.getParkPackageCarRel()) {
                        carNums.add(packageCarRel.getCarNum());
                    }
                    this.addCarDevRelConditon(delCarDevRels, authPackage, carNums);
                }
                if (StringUtils.isNotBlank(authPackage.getCardNumber())) {
                    List<String> cardNums = new ArrayList<>();
                    cardNums.add(authPackage.getCardNumber());
                    this.addCarDevRelConditon(delCarDevRels, authPackage, cardNums);
                }
            }
        }
    }

    /**
     * 添加下发修改条件
     * 
     * @param delCarDevRels
     * @param authPackage
     * @param carNums void
     */
    private void addCarDevRelConditon(List<CarDevRelConditon> delCarDevRels,
            AuthPackage authPackage, List<String> carNums) {
        List<String> parkCodes = new ArrayList<>();
        for (ParkPackageParkRel packageParkRel : authPackage.getParkPackageParkRel()) {
            parkCodes.add(packageParkRel.getParkCode());
        }
        CarDevRelConditon devRelDto = new CarDevRelConditon();
        devRelDto.setCarNumList(carNums);
        devRelDto.setParkCodeList(parkCodes);
        delCarDevRels.add(devRelDto);
    }

    @Override
    public Page<AuthPackage> selectPageList(ParkAuthPackageCondition condition) {
        PageRequest<ParkAuthPackageCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(condition.getCurrentPage());
        pageRequest.setPageSize(condition.getPageSize());
        pageRequest.setFilters(condition);
        return parkAuthPackageDao.selectPageList(pageRequest);
    }

    @Override
    public List<AuthPackage> selectList(ParkAuthPackageCondition condition) {
        return parkAuthPackageDao.selectList(condition);
    }

    private void insertValid(ParkAuthPackage parkAuthPackage) {
        if (StringUtils.isBlank(parkAuthPackage.getOwnerId())
                || StringUtils.isBlank(parkAuthPackage.getCarportCode())) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        List<ParkAuthPackage> result = parkAuthPackageDao
                .selectParkAuthPackageByCarportCode(parkAuthPackage.getCarportCode());
        if (CollectionUtils.isNotEmpty(result)) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_AUTHPACKAGE_CARPORT_OCCPIED);
        }
    }

    @Override
    public List<AuthPackageDto> getMonthCarByCarNum(String carNum) {
        ParkAuthPackageCondition packageCondition = new ParkAuthPackageCondition();
        packageCondition.setCarNum(carNum);
        List<Short> caportTypes = new ArrayList<>();
        caportTypes.add(CarportType.MONTHWARRANTY.getType());
        caportTypes.add(CarportType.PROPERTYRIGHTS.getType());
        packageCondition.setCarportTypes(caportTypes);
        List<AuthPackage> packageList = parkAuthPackageDao.selectList(packageCondition);
        if (CollectionUtils.isEmpty(packageList)) {
            return Collections.emptyList();
        }
        List<AuthPackageDto> packageDtoList = new ArrayList<>();

        StringBuilder userIds = new StringBuilder();
        List<String> parkRuleIds = new ArrayList<>();
        for (int i = 0; i < packageList.size(); i++) {
            parkRuleIds.add(packageList.get(i).getParkRuleId());
            userIds.append(packageList.get(i).getOwnerId());
            if (i != packageList.size() - 1) {
                userIds.append(",");
            }
        }
        // 访问主数据通过用户名查询用户id
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setUuid(userIds.toString());
        List<BaseUserDto> userList = userClientImpl.getUser(baseUserDto);
        Map<String, String> userMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(userList)) {
            for (BaseUserDto userDto : userList) {
                userMap.put(userDto.getUuid(), userDto.getName());
            }
        }
        List<ParkRule> selectByRuleIds = parkRuleDao.selectByRuleIds(parkRuleIds);
        Map<String, Integer> parkRuleMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(selectByRuleIds)) {
            for (ParkRule parkRule : selectByRuleIds) {
                String feeDetail = parkRule.getDetail();
                RuleDetailDto ruleDto = JSON.parseObject(feeDetail, RuleDetailDto.class);
                parkRuleMap.put(parkRule.getUuid(), ruleDto.getPayMoney());
            }
        }
        for (AuthPackage authPackage : packageList) {
            AuthPackageDto packageDto = new AuthPackageDto();
            BeanUtils.copyProperties(authPackage, packageDto);
            packageDto.setOwnerName(userMap.get(authPackage.getOwnerId()));
            packageDto.setMoney(parkRuleMap.get(authPackage.getParkRuleId()));
            packageDtoList.add(packageDto);
        }

        return packageDtoList;
    }

    @Override
    public List<AuthPackageDto> getMonthCarByOwnerName(String ownerName) {
        // 访问主数据通过用户名查询用户id
        BaseUserDto baseUserDto = new BaseUserDto();
        baseUserDto.setName(ownerName);
        List<BaseUserDto> userList = userClientImpl.getUser(baseUserDto);
        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }
        Map<String, String> userMap = new HashMap<>();
        List<String> ownerIds = new ArrayList<>();
        for (BaseUserDto baseUser : userList) {
            userMap.put(baseUser.getUuid(), baseUser.getName());
            ownerIds.add(baseUser.getUuid());
        }
        List<AuthPackage> packageList = parkAuthPackageDao.selectByOwnerIdsWithoutTemp(ownerIds);
        if (CollectionUtils.isEmpty(packageList)) {
            return Collections.emptyList();
        }
        List<String> parkRuleIds = new ArrayList<>();
        for (AuthPackage authPackage : packageList) {
            parkRuleIds.add(authPackage.getParkRuleId());
        }
        List<ParkRule> selectByRuleIds = parkRuleDao.selectByRuleIds(parkRuleIds);
        Map<String, Integer> parkRuleMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(selectByRuleIds)) {
            for (ParkRule parkRule : selectByRuleIds) {
                String feeDetail = parkRule.getDetail();
                RuleDetailDto ruleDto = JSON.parseObject(feeDetail, RuleDetailDto.class);
                parkRuleMap.put(parkRule.getUuid(), ruleDto.getPayMoney());
            }
        }
        List<AuthPackageDto> packageDtoList = new ArrayList<>();
        for (AuthPackage authPackage : packageList) {
            AuthPackageDto packageDto = new AuthPackageDto();
            BeanUtils.copyProperties(authPackage, packageDto);
            packageDto.setOwnerName(userMap.get(authPackage.getOwnerId()));
            packageDto.setMoney(parkRuleMap.get(authPackage.getParkRuleId()));
            packageDtoList.add(packageDto);
        }
        return packageDtoList;
    }


    /**
     * 根据车场号和车牌号码批量更新车辆下发表
     * 
     * @param info
     * @param authPackage
     * @param change
     * @return int
     */
    @SuppressWarnings("unchecked")
    private int updateCarDevRel(Map<String, List<String>> info) {
        int result = 0;
        List<String> newCarNums = info.get("newCarNums");
        List<String> oldCarNums = info.get("oldCarNums");
        List<String> newParkCodes = info.get("newParkCodes");
        List<String> oldParkCodes = info.get("oldParkCodes");
        List<String> sameCarnums =
                (List<String>) CollectionUtils.intersection(newCarNums, oldCarNums);
        List<String> addCarnums = (List<String>) CollectionUtils.subtract(newCarNums, oldCarNums);
        List<String> delCarnums = (List<String>) CollectionUtils.subtract(oldCarNums, newCarNums);
        List<String> addParkCodes =
                (List<String>) CollectionUtils.subtract(newParkCodes, oldParkCodes);
        List<String> delParkCodes =
                (List<String>) CollectionUtils.subtract(oldParkCodes, newParkCodes);
        List<CarDevRelConditon> delCarDevRels = new ArrayList<>();
        List<ParkCarDevRel> parkCarDevRels = new ArrayList<>();
        Map<String, List<String>> devMap = new HashMap<>();
        // 车辆下发新增
        if (CollectionUtils.isNotEmpty(addCarnums) && CollectionUtils.isNotEmpty(newParkCodes)) {
            this.getCarDevIds(newParkCodes, devMap);
            this.createCarDevRel(newParkCodes, addCarnums, parkCarDevRels, devMap);
        }
        // 车辆下发新增
        if (CollectionUtils.isNotEmpty(sameCarnums) && CollectionUtils.isNotEmpty(addParkCodes)) {
            this.createCarDevRel(addParkCodes, sameCarnums, parkCarDevRels, devMap);
        }
        // 车辆下发删除
        if (CollectionUtils.isNotEmpty(delCarnums) && CollectionUtils.isNotEmpty(oldParkCodes)) {
            CarDevRelConditon carDevRelDto = new CarDevRelConditon();
            carDevRelDto.setCarNumList(delCarnums);
            carDevRelDto.setParkCodeList(oldParkCodes);
            delCarDevRels.add(carDevRelDto);
        }
        // 车辆下发删除
        if (CollectionUtils.isNotEmpty(sameCarnums) && CollectionUtils.isNotEmpty(delParkCodes)) {
            CarDevRelConditon carDevRelDto = new CarDevRelConditon();
            carDevRelDto.setCarNumList(sameCarnums);
            carDevRelDto.setParkCodeList(delParkCodes);
            delCarDevRels.add(carDevRelDto);
        }
        if (CollectionUtils.isNotEmpty(delCarDevRels)) {
            ParkCarDevRel devRel = new ParkCarDevRel();
            devRel.setOptType(CarDevRelOptType.DEL.getType());
            devRel.setStatus(CarDevRelStatus.SEND.getType());
            result += carDevRelMapper.updateStatusByCarNumsAndParkCodes(devRel, delCarDevRels);
        }
        if (CollectionUtils.isNotEmpty(parkCarDevRels)) {
            result += parkCarDevRelDao.insertPackageCarRelBatch(parkCarDevRels);
        }
        return result;
    }

    /**
     * 通过车场号查询对应的设配id
     * 
     * @param newParkCodes
     * @param devMap void
     */
    private void getCarDevIds(List<String> newParkCodes, Map<String, List<String>> devMap) {
        List<ChannelRel> channelByParkCodes = channelMapper
                .selectChannelByParkCodesAndDevType(ChannelDevType.CAMERA.getType(), newParkCodes);
        if (CollectionUtils.isNotEmpty(channelByParkCodes)) {
            for (ChannelRel channelRel : channelByParkCodes) {
                List<String> devCodes = new ArrayList<>();
                for (ParkChannelRel parkChannelRel : channelRel.getParkChannelRelList()) {
                    devCodes.add(parkChannelRel.getDevCode());
                }
                devMap.put(channelRel.getParkCode(), devCodes);
            }
        }
    }

    /**
     * 根据参数创建实体
     * 
     * @param addParkCodes
     * @param addCarnums
     * @param parkCarDevRels
     * @param devMap void
     */
    private void createCarDevRel(List<String> addParkCodes, List<String> addCarnums,
            List<ParkCarDevRel> parkCarDevRels, Map<String, List<String>> devMap) {
        if (devMap == null || devMap.size() == 0) {
            return;
        }
        for (String carNum : addCarnums) {
            for (String parkCode : addParkCodes) {
                for (String devCode : devMap.get(parkCode)) {
                    ParkCarDevRel parkCarDevRel = new ParkCarDevRel();
                    parkCarDevRel.setUuid(UuidUtil.generate());
                    parkCarDevRel.setCarNum(carNum);
                    parkCarDevRel.setParkCode(parkCode);
                    parkCarDevRel.setDevCode(devCode);
                    parkCarDevRel.setCreateTime(new Date());
                    parkCarDevRel.setListType(CarListType.NORMAL.getType());
                    parkCarDevRel.setOptType(CarDevRelOptType.ADD.getType());
                    parkCarDevRel.setStatus(CarDevRelStatus.SEND.getType());
                    parkCarDevRels.add(parkCarDevRel);
                }
            }
        }
    }

}
