/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.authpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.authpackage.ParkAuthPackageCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.authpackage.entity.AuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.ParkAuthPackageService;
import com.eg.egsc.scp.parkinglotcomponent.service.authpackage.dto.AuthPackageDto;
import com.eg.egsc.scp.parkinglotcomponent.service.charge.ParkChargeService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.authpackage.ParkAuthPackageVo;

import io.swagger.annotations.ApiOperation;

/**
 * 授权套餐控制层接口口
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
@RestController
@RequestMapping(value = "/package")
public class ParkAuthPackageController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ParkAuthPackageService parkAuthPackageServiceImpl;
    
    @Autowired
    private ParkChargeService parkChargeServiceImpl;
    
    /**
     * 添加授权套餐
     * 
     * @param parkPackageVo
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException ResultMessage
     */
    @RequestMapping(value = "/insertPackage", method = RequestMethod.POST)
    @Transactional
    public ResultMessage insertCar(@Valid @RequestBody ParkAuthPackageVo parkPackageVo) throws IllegalAccessException, InvocationTargetException {
        logger.info("insertCar param: {}", JSON.toJSONString(parkPackageVo));
        AuthPackage pPackage = parkPackageVo.convertVOToPO();
        parkAuthPackageServiceImpl.insert(pPackage);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * 修改授权套餐
     * 
     * @param parkPackageVo
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException ResultMessage
     */
    @RequestMapping(value = "/updatePackage", method = RequestMethod.POST)
    public ResultMessage updateCar(@Valid @RequestBody ParkAuthPackageVo parkPackageVo) throws IllegalAccessException, InvocationTargetException {
        logger.info("updateCar param: {}", JSON.toJSONString(parkPackageVo));
        AuthPackage pPackage = parkPackageVo.convertVOToPO();
        parkAuthPackageServiceImpl.update(pPackage);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * 批量删除授权套餐
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeletePackage", method = RequestMethod.POST)
    public ResultMessage batchDeleteCars(@RequestBody List<String> ids) {
        logger.info("batchDeleteCars param: {}", JSON.toJSONString(ids));
        parkAuthPackageServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * 授权套餐分页查询
     * 
     * @param condition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/listPackages", method = RequestMethod.GET)
    public ResultMessage selectPageList(ParkAuthPackageCondition condition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: {}", JSON.toJSONString(condition));
        Page<AuthPackage> page = parkAuthPackageServiceImpl.selectPageList(condition);
        PageVo<ParkAuthPackageVo> pageVO = new PageVo<>(page, ParkAuthPackageVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }
    
    /**
     * 缴费充值
     * 
     * @param charge
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public ResultMessage charge(ParkCharge charge)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: {}", JSON.toJSONString(charge));
        parkChargeServiceImpl.charge(charge);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * 根据车牌号获得套餐信息
     * 
     * @param carNum
     * @return ResultMessage
     */
    @ApiOperation("根据车牌号获得套餐信息")
    @RequestMapping(value = "/getMonthCarByCarNum", method = RequestMethod.GET)
    public ResultMessage getMonthCarByCarNum(@RequestParam(value = "carNum") String carNum){
        logger.info("getMonthCarByCarNum param: {}", carNum);
        List<AuthPackageDto> authPackages = parkAuthPackageServiceImpl.getMonthCarByCarNum(carNum);
        return ResultMessage.createSuccessResult(authPackages);
        
    }
    
    /**
     * 根据业主名获得套餐信息
     * 
     * @param ownerName
     * @return ResultMessage
     */
    @ApiOperation("根据业主名获得套餐信息")
    @RequestMapping(value = "/getMonthCarByOwnerName", method = RequestMethod.GET)
    public ResultMessage getMonthCarByOwnerName(@RequestParam(value = "ownerName") String ownerName){
        logger.info("getMonthCarByCarNum param: {}", ownerName);
        List<AuthPackageDto> authPackages = parkAuthPackageServiceImpl.getMonthCarByOwnerName(ownerName);
        return ResultMessage.createSuccessResult(authPackages);
        
    }
    
}
