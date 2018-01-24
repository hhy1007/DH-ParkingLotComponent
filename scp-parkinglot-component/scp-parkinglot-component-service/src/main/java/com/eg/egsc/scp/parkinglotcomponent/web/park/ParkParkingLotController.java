/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.park;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.park.ParkingLotCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkParkingLotService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.park.ParkParkingLotVo;

/**
 * 停车场管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/parkingLot")
public class ParkParkingLotController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkParkingLotService parkParkingLotServiceImpl;

    /**
     * 添加停车场
     * 
     * @param parkParkingLotVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertParkingLot", method = RequestMethod.POST)
    public ResultMessage insertParkingLot(@Valid @RequestBody ParkParkingLotVo parkParkingLotVo) {
        logger.info("insertParkingLot param: " + JSON.toJSONString(parkParkingLotVo));
        ParkParkingLot parkParkingLot = parkParkingLotVo.convertVOToPO();
        parkParkingLotServiceImpl.insert(parkParkingLot);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param parkingLotCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(ParkingLotCondition parkingLotCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(parkingLotCondition));
        Page<ParkParkingLot> page = parkParkingLotServiceImpl.selectPageList(parkingLotCondition);
        PageVo<ParkParkingLotVo> pageVO =
                new PageVo<>(page, ParkParkingLotVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    /**
     * 删除停车场
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteParkingLots", method = RequestMethod.GET)
    public ResultMessage deleteParkingLots(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteParkingLots param: " + JSON.toJSONString(ids));
        parkParkingLotServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 更新停车场
     * 
     * @param parkParkingLotVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateParkingLot", method = RequestMethod.POST)
    public ResultMessage updateParkingLot(@Valid @RequestBody ParkParkingLotVo parkParkingLotVo) {
        logger.info("updateParkingLot param: " + JSON.toJSONString(parkParkingLotVo));
        ParkParkingLot parkParkingLot = parkParkingLotVo.convertVOToPO();
        parkParkingLotServiceImpl.update(parkParkingLot);
        return ResultMessage.createSuccessResult(null);
    }
}
