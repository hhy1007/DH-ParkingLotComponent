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
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.CarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.ParkCarportService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.CarportVo;

/**
 * 车位管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/carport")
public class ParkCarportController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkCarportService parkCarportServiceImpl;

    /**
     * 根据多个停车场编号和车位和车位编号模糊分页查询没有授权的车位信息
     * 
     * @param carportCondition
     * @return ResultMessage
     */
    @RequestMapping(value = "/selectByParkIds", method = RequestMethod.GET)
    public ResultMessage selectByParkIds(CarportCondition carportCondition) {
        Page<ParkCarport> page = parkCarportServiceImpl.selectByParkId(carportCondition);
        return ResultMessage.createSuccessResult(page);
    }

    /**
     * 插入车位信息
     * 
     * @param carportVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertCarport", method = RequestMethod.POST)
    public ResultMessage insertCarport(@Valid @RequestBody CarportVo carportVo) {
        logger.info("insertCarport param: " + JSON.toJSONString(carportVo));
        ParkCarport parkCarport = carportVo.convertVOToPO();
        parkCarportServiceImpl.insert(parkCarport);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 批量删除
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteCarports", method = RequestMethod.GET)
    public ResultMessage deleteParkCarports(@RequestParam(value = "ids") List<String> ids) {
        logger.info("deleteParkCarport param: " + JSON.toJSONString(ids));
        parkCarportServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 修改车位信息
     * 
     * @param carportVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateCarport", method = RequestMethod.POST)
    public ResultMessage updateParkCarport(@Valid @RequestBody CarportVo carportVo) {
        logger.info("updateCarport param: " + JSON.toJSONString(carportVo));
        ParkCarport parkCarport = carportVo.convertVOToPO();
        parkCarportServiceImpl.update(parkCarport);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param carportCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(CarportCondition carportCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("listCarports param: " + JSON.toJSONString(carportCondition));
        Page<ParkCarport> page = parkCarportServiceImpl.selectPageList(carportCondition);
        PageVo<CarportVo> pageVO = new PageVo<>(page, CarportVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

}
