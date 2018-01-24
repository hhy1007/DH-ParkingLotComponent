/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.config.ParkSysConfigCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;
import com.eg.egsc.scp.parkinglotcomponent.service.config.ParkSysConfigService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.config.ParkSysConfigVo;

@RestController
@RequestMapping(value = "/config")
public class ParkSysConfigController {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ParkSysConfigService parkSysConfigServiceImpl;

  /**
   * 系统设置表 控制层接口
   * 
   * @param condition
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException ResultMessage
   */
  @RequestMapping(value = "/listParkSysConfig", method = RequestMethod.GET)
  public ResultMessage selectPageList(ParkSysConfigCondition condition)
      throws InstantiationException, IllegalAccessException {
    Page<ParkSysConfig> requestPage = parkSysConfigServiceImpl.selectPageList(condition);
    PageVo<ParkSysConfigVo> pageVo = new PageVo<>(requestPage, ParkSysConfigVo.class);
    return ResultMessage.createSuccessResult(pageVo);
  }
   
  @RequestMapping(value = "/updateConfigByConfigSeq", method = RequestMethod.POST)
  public ResultMessage update(@RequestBody ParkSysConfig parkSysConfig) {
      logger.info("updateConfigByConfigSeq param: " + JSON.toJSONString(parkSysConfig));
//      ParkSysConfig parkLedCarportRel = parkSysConfig.convertVOToPO();
      parkSysConfigServiceImpl.updateConfigByConfigSeq(parkSysConfig);
      return ResultMessage.createSuccessResult(parkSysConfig);
  }
}
