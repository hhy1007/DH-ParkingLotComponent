/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.car;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.car.CarVo;

/**
 * 车辆管理 控制层接口
 * 
 * @author zhangli
 * @since 2018年1月18日
 */
@RestController
@RequestMapping(value = "/car")
public class CarController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarService carServiceImpl;
    
    @Autowired  
    private DiscoveryClient discoveryClient;
    
    /**
     * 添加车辆信息
     * 
     * @param carVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @Transactional
    public ResultMessage insertCar(@Valid @RequestBody CarVo carVo) {
        logger.info("insertCar param: {}", JSON.toJSONString(carVo));
        ParkCar car = carVo.convertVOToPO();
        carServiceImpl.insert(car);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 修改车辆信息
     * 
     * @param carVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultMessage updateCar(@Valid @RequestBody CarVo carVo) {
        logger.info("updateCar param: {}", JSON.toJSONString(carVo));
        ParkCar car = carVo.convertVOToPO();
        carServiceImpl.update(car);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 批量删除车辆信息
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public ResultMessage batchDeleteCars(@RequestBody List<String> ids) {
        logger.info("batchDeleteCars param: {}", JSON.toJSONString(ids));
        carServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 车辆管理 分页查询
     * 
     * @param carCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    public ResultMessage selectPageList(CarCondition carCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: {}", JSON.toJSONString(carCondition));
        Page<ParkCar> page = carServiceImpl.selectPageList(carCondition);
        PageVo<CarVo> pageVO = new PageVo<>(page, CarVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }
    
    /**
     * getServiceInfo  
     * 
     * @Methods Name getServiceInfo
     * @Create In 2017年12月18日 By zhangli
     * @return ResultMessage
     */
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public ResultMessage getServiceInfo() {
        logger.info("services.. ");
        for(String s :  discoveryClient.getServices()){  
            logger.info("services: " + s);  
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);  
            for(ServiceInstance si : serviceInstances){  
                logger.info(s + ":getHost()=" + si.getHost());  
                logger.info(s + ":getPort()=" + si.getPort());  
                logger.info(s + ":getServiceId()=" + si.getServiceId());  
                logger.info(s + ":getUri()=" + si.getUri());  
                logger.info(s + ":getMetadata()=" + si.getMetadata());  
            }  
        }  
        List<ServiceInstance> list = discoveryClient.getInstances("SCP-IMAGEMGMTCOMPONENT");  
        if (CollectionUtils.isNotEmpty(list)) {  
            logger.info("SCP-IMAGEMGMTCOMPONENT address: {}", list.get(0).getUri().toString());  
        }
        return ResultMessage.createSuccessResult(null);
    }

}
