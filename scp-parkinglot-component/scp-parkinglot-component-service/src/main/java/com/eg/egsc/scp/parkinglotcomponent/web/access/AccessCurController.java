/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.access;

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
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.service.integration.dto.CarInOutDto;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessCurService;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkExitParkingLotService;
import io.swagger.annotations.ApiOperation;

/**
 * AccessCurController
 * 
 * @author xiangdaoping
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/accessCur")
public class AccessCurController extends BaseWebController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkAccessCurService parkAccessCurServiceImpl;

    @Autowired
    private ParkExitParkingLotService parkExitParkingLotServiceImpl;

    /**
     * 根据入场id查询停车场信息和收费规则信息
     * 
     * @param id
     * @return ResultMessage
     */
    @RequestMapping(value = "/selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey",
            method = RequestMethod.GET)
    @Transactional
    public ResultMessage selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(String id) {
        AccessCur accessCur =
                parkAccessCurServiceImpl.selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey(id);
        return ResultMessage.createSuccessResult(accessCur);
    }

    /**
     * <p>
     * 重新计费接口
     * 
     * @param carInOutDto
     * @return ResultMessage
     */
    @ApiOperation(value = "重新计费接口", notes = "重新计费接口")
    @RequestMapping(value = "/recharge/select", method = RequestMethod.POST)
    @Transactional
    public ResultMessage recharge(@Valid @RequestBody CarInOutDto carInOutDto) {
        logger.info("recharge param: {}", JSON.toJSONString(carInOutDto));
        CarInOutDto returnCarInOutDto = this.parkExitParkingLotServiceImpl.reBilling(carInOutDto);
        return ResultMessage.createSuccessResult(returnCarInOutDto);

    }

    /**
     * 批量删除在场车辆
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/forceout/batch<delete>", method = RequestMethod.POST)
    public ResultMessage batchDeleteCars(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteCars param: " + JSON.toJSONString(ids));
        parkAccessCurServiceImpl.deleteByIds(ids);

        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 导出在场车辆查询
     * 
     * @param accessCurCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/export/select", method = RequestMethod.GET)
    public ResultMessage exportAccessList(AccessCurCondition accessCurCondition) {
        logger.info("selectPageList param: " + JSON.toJSONString(accessCurCondition));
        // 从数据库获取适合筛选条件的车辆信息
        List<ParkAccessCur> duc = parkAccessCurServiceImpl.selectList(accessCurCondition);
        return ResultMessage.createSuccessResult(duc);
    }

}
