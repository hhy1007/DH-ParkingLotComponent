/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.parked;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkLedCarportRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedCurService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.parked.ParkLedCarportRelVo;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.parked.ParkedCurVo;

/**
 * 车位功能 控制层接口
 * 
 * @author gongqian
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/parked")
public class ParkedCurController extends BaseWebController {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ParkedCurService parkedCurServiceImpl;

  /**
   * 车位状态变更
   * 
   * @param parkedCurVo
   * @return ResultMessage
   */
  @RequestMapping(value = "updateParkingStatus", method = RequestMethod.POST)
  public ResultMessage updateParkingStatus(ParkedCurVo parkedCurVo) {
    logger.info("updateParkingStatus param: " + JSON.toJSONString(parkedCurVo));
    ParkParkedCur parkParkedCur = parkedCurVo.convertVOToPO();
    parkedCurServiceImpl.updateParkingStatus(parkParkedCur);
    return ResultMessage.createSuccessResult(null);
  }

  /**
   * 更新诱导屏余位数
   * 
   * @param parkLedCarportRelVo
   * @return ResultMessage
   */
  @RequestMapping(value = "updateLedCarport", method = RequestMethod.POST)
  public ResultMessage updateLedCarport(ParkLedCarportRelVo parkLedCarportRelVo) {
    logger.info("updateLedCarport param: " + JSON.toJSONString(parkLedCarportRelVo));
    ParkLedCarportRel parkLedCarportRel = parkLedCarportRelVo.convertVOToPO();
    parkedCurServiceImpl.updateLedCarport(parkLedCarportRel);
    return ResultMessage.createSuccessResult(null);
  }

  /**
   * 实时车位分页查询
   * 
   * @param condition
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException ResultMessage
   */
  @RequestMapping(value = "/listParkHis", method = RequestMethod.GET)
  public ResultMessage selectPageList(ParkedCarportCondition condition)
      throws InstantiationException, IllegalAccessException {
    Page<ParkParkedCur> requestPage = parkedCurServiceImpl.selectPageList(condition);
    PageVo<ParkedCurVo> pageVo = new PageVo<>(requestPage, ParkedCurVo.class);
    return ResultMessage.createSuccessResult(pageVo);
  }

  /**
   * 根据车位号查询
   * 
   * @param carportCode
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException ResultMessage
   */
  @RequestMapping(value = "/selectByCarportCode", method = RequestMethod.GET)
  public ResultMessage selectByCarportCode(String carportCode)
      throws InstantiationException, IllegalAccessException {
    List<ParkParkedCur> parkParkedCur = parkedCurServiceImpl.selectByCarportCode(carportCode);
    PageVo<ParkedCurVo> pageVO = new PageVo<>(parkParkedCur, ParkedCurVo.class);
    return ResultMessage.createSuccessResult(pageVO);
  }

  /**
   * 根据车牌号查询
   * 
   * @param carNum
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException ResultMessage
   */
  @RequestMapping(value = "/selectByCarNum", method = RequestMethod.GET)
  public ResultMessage selectByCarNum(String carNum)
      throws InstantiationException, IllegalAccessException {
    List<ParkParkedCur> parkParkedCur = parkedCurServiceImpl.selectByCarNum(carNum);
    PageVo<ParkedCurVo> pageVo = new PageVo<>(parkParkedCur, ParkedCurVo.class);
    return ResultMessage.createSuccessResult(pageVo);
  }
}
