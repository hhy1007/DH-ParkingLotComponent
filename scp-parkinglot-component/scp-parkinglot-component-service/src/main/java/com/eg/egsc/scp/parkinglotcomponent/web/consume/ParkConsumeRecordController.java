/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.consume;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.consume.ConsumeRecordCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkConsumeRecord;
import com.eg.egsc.scp.parkinglotcomponent.service.consume.ParkConsumeRecordService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.consume.ConsumeRecordVo;
/**
 * 消费记录控制层
 * @Class Name ParkConsumeRecordController
 * @Author xiaoxiaojie
 * @Create In 2017年12月18日
 */
@RestController
@RequestMapping(value="/consume")
public class ParkConsumeRecordController extends BaseWebController {
  
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
  
    @Autowired
    ParkConsumeRecordService parkConsumeRecordServiceImpl;
    
    /**
     * 查询消费记录 分页查询
     * @Methods Name selectPageConsumeRecordList
     * @Create In 2017年12月18日 By xiaoxiaojie
     * @param consumeRecordCondition
     * @return ResultMessage
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value="/listRecords",method=RequestMethod.GET)
    public ResultMessage queryPageListConsumeRecord(ConsumeRecordCondition consumeRecordCondition) 
            throws InstantiationException,IllegalAccessException {
        log.info("selectPageConsumeRecordList params:"+JSON.toJSONString(consumeRecordCondition));
        Page<ParkConsumeRecord> consumeRecordList = parkConsumeRecordServiceImpl.selectPageConsumeRecordList(consumeRecordCondition);   
        PageVo<ConsumeRecordVo> pageVo = new PageVo<>(consumeRecordList,ConsumeRecordVo.class);
        return ResultMessage.createSuccessResult(pageVo);
    }
}
