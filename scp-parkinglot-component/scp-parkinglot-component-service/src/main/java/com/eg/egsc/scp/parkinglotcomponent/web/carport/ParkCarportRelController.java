/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.carport;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportRelService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.CarportRelVo;

/**
 * 诱导屏绑定车位管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/carportRel")
public class ParkCarportRelController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkCarportRelService parkCarportRelServiceImpl;

    /**
     * carportRelVo
     * 
     * @param carportRelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertCarportRel", method = RequestMethod.POST)
    public ResultMessage insertCarportRel(@Valid @RequestBody CarportRelVo carportRelVo) {
        logger.info("insertCarportRel param: " + JSON.toJSONString(carportRelVo));
        ParkLedCarportRel parkLedCarportRel = carportRelVo.convertVOToPO();
        parkCarportRelServiceImpl.insert(parkLedCarportRel);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 批量删除
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteCarportRels", method = RequestMethod.GET)
    public ResultMessage deleteParkCarportRels(@RequestParam(value = "ids") List<String> ids) {
        logger.info("deleteParkCarportRels param: " + JSON.toJSONString(ids));
        parkCarportRelServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }
    
    /**
     * 修诱导屏绑定车位位信息
     * 
     * @param carportRelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateCarportRel", method = RequestMethod.POST)
    public ResultMessage updateParkCarportRel(@Valid @RequestBody CarportRelVo carportRelVo) {
        logger.info("updateCarportRel param: " + JSON.toJSONString(carportRelVo));
        ParkLedCarportRel parkLedCarportRel = carportRelVo.convertVOToPO();
        parkCarportRelServiceImpl.update(parkLedCarportRel);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param carportRelCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(CarportRelCondition carportRelCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(carportRelCondition));
        Page<ParkLedCarportRel> page = parkCarportRelServiceImpl.selectPageList(carportRelCondition);
        PageVo<CarportRelVo> pageVO = new PageVo<>(page, CarportRelVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }
}
