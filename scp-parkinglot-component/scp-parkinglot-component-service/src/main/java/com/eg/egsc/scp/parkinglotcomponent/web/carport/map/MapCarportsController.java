/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.carport.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.MapCarportsService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.CarportVo;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.map.MapCarportsVo;

/**
 * 地图展示车位使用的实现接口
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/carport/map")
public class MapCarportsController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MapCarportsService mapCarportsServiceImpl;

    /**
     * 修改车位在地图上的坐标位置
     * 
     * @param mapCarportsVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateCarports", method = RequestMethod.POST)
    public ResultMessage updateCarportslocation(MapCarportsVo mapCarportsVo) {
        logger.info(" updateCarportslocation param: " + JSON.toJSONString(mapCarportsVo));
        mapCarportsServiceImpl.updateCarportslocation(mapCarportsVo);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 车位分页查询
     * 
     * @param mapCarportCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/listCarports", method = RequestMethod.GET)
    public ResultMessage listCarports(MapCarportsCondition mapCarportCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info(" listCarports param: " + JSON.toJSONString(mapCarportCondition));
        Page<ParkCarport> page = mapCarportsServiceImpl.selectPageList(mapCarportCondition);
        PageVo<CarportVo> pageVO = new PageVo<>(page, CarportVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

}
