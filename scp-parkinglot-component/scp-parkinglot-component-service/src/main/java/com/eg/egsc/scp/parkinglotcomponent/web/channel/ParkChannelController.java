/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.channel;

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
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.channel.ChannelVo;
/**
 * 车场通道管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/channel")
public class ParkChannelController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkChannelService parkChannelServiceImpl;

    /**
     * 新增车道信息
     * 
     * @param channelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertChannel", method = RequestMethod.POST)
    public ResultMessage insertChannel(@Valid @RequestBody ChannelVo channelVo) {
        logger.info("insertChannel param: " + JSON.toJSONString(channelVo));
        ParkChannel parkChannel = channelVo.convertVOToPO();
        parkChannelServiceImpl.insert(parkChannel);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param channelCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(ChannelCondition channelCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(channelCondition));
        Page<ParkChannel> page = parkChannelServiceImpl.selectPageList(channelCondition);
        PageVo<ChannelVo> pageVO = new PageVo<>(page, ChannelVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    /**
     * 批量删除停车场通道
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteParkChannels", method = RequestMethod.GET)
    public ResultMessage deleteParkChannels(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteParkChannels param: " + JSON.toJSONString(ids));
        parkChannelServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 修改停车场通道
     * 
     * @param channelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateChannel", method = RequestMethod.POST)
    public ResultMessage updateChannel(@Valid @RequestBody ChannelVo channelVo) {
        logger.info("updateChannel param: " + JSON.toJSONString(channelVo));
        ParkChannel parkChannel = channelVo.convertVOToPO();
        parkChannelServiceImpl.update(parkChannel);
        return ResultMessage.createSuccessResult(null);
    }

}
