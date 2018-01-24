/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.reservation;

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
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.reservation.ParkReservationCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.service.reservation.ParkReservationService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.reservation.ParkReservationVo;


/**
 * 停车预约控制层接口
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
@RestController
@RequestMapping(value = "/reservation")
public class ParkReservationController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ParkReservationService parkReservationServiceImpl;
    
    /**
     * 添加停车预约
     * 
     * @param parkReservationVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertReservation", method = RequestMethod.POST)
    public ResultMessage createParkReservation(@Valid @RequestBody ParkReservationVo parkReservationVo) {
        
        logger.info("insertParkReservation param: " + JSON.toJSONString(parkReservationVo));
        ParkReservation parkReservation = parkReservationVo.convertVOToPO();
        parkReservationServiceImpl.insert(parkReservation);
        return ResultMessage.createSuccessResult(null);
        
    }
    
    /**
     * 更新停车预约
     * 
     * @param parkReservationVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateReservation", method = RequestMethod.POST)
    public ResultMessage updateParkReservation(@Valid @RequestBody ParkReservationVo parkReservationVo) {
        
        logger.info("updateParkReservation param: " + JSON.toJSONString(parkReservationVo));
        ParkReservation parkReservation = parkReservationVo.convertVOToPO();
        parkReservationServiceImpl.update(parkReservation);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 批量根据id删除记录
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteReservation", method = RequestMethod.GET)
    public ResultMessage deleteParkCarport(@RequestParam(value = "ids") List<String> ids) {
        logger.info("deleteParkReservation param: " + JSON.toJSONString(ids));
        parkReservationServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 分页查询预约记录
     * 
     * @param parkReservationCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/listReservations", method = RequestMethod.GET)
    public ResultMessage selectPageList(ParkReservationCondition parkReservationCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(parkReservationCondition));
        Page<ParkReservation> page = parkReservationServiceImpl.selectPageList(parkReservationCondition);
        PageVo<ParkReservationVo> pageVO = new PageVo<>(page, ParkReservationVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    
}
