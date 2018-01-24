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

import com.eg.egsc.framework.service.base.web.BaseWebController;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.page.PageVo;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.cur.ParkedCarportCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedHis;
import com.eg.egsc.scp.parkinglotcomponent.service.parked.ParkedHisService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.parked.ParkedHisVo;

/**
 * 车位表控制层接口
 * 
 * @author liudongteng
 * @since 2018年1月18日
 */
@RestController
@RequestMapping(value = "/his")
public class ParkedHisController extends BaseWebController {
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ParkedHisService parkedHisServiceImpl;

  /**
   * 历史车位分页查询
   * 
   * @param condition
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException ResultMessage
   */
  @RequestMapping(value = "/listParkHis", method = RequestMethod.GET)
  public ResultMessage selectPageList(ParkedCarportCondition condition)
      throws InstantiationException, IllegalAccessException {
    Page<ParkParkedHis> requestPage = parkedHisServiceImpl.selectPageList(condition);
    PageVo<ParkedHisVo> pageVo = new PageVo<>(requestPage, ParkedHisVo.class);
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
    List<ParkParkedHis> parkParkedHis = parkedHisServiceImpl.selectByCarportCode(carportCode);
    PageVo<ParkedHisVo> pageVO = new PageVo<>(parkParkedHis, ParkedHisVo.class);
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
    List<ParkParkedHis> parkParkedHis = parkedHisServiceImpl.selectByCarNum(carNum);
    PageVo<ParkedHisVo> pageVo = new PageVo<>(parkParkedHis, ParkedHisVo.class);
    return ResultMessage.createSuccessResult(pageVo);
  }

}
