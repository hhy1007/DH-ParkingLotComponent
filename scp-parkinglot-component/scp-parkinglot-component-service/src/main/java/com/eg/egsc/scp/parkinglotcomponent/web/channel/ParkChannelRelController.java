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
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.service.channel.ParkChannelRelService;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.channel.ChannelRelVo;

/**
 * 车场通道绑定管理 控制层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
@RestController
@RequestMapping(value = "/channelRel")
public class ParkChannelRelController extends BaseWebController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkChannelRelService parkChannelRelServiceImpl;

    /**
     * 根据多个通道id查询通道绑定信息
     * 
     * @param channeIds
     * @return ResultMessage
     */
    @RequestMapping(value = "/selectChannelRelByIds", method = RequestMethod.GET)
    public ResultMessage selectChannelRelByIds(List<String> channeIds) {
        List<ParkChannelRel> parkChannelRelList =
                parkChannelRelServiceImpl.selectChannelRelByIds(channeIds);
        return ResultMessage.createSuccessResult(parkChannelRelList);
    }

    /**
     * 添加车场通道绑定
     * 
     * @param channelRelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/insertChannelRel", method = RequestMethod.POST)
    public ResultMessage insertChannelRel(@Valid @RequestBody ChannelRelVo channelRelVo) {
        logger.info("insertChannelRel param: " + JSON.toJSONString(channelRelVo));
        ParkChannelRel parkChannelRel = channelRelVo.convertVOToPO();
        parkChannelRelServiceImpl.insert(parkChannelRel);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 此方法用于分页查询
     * 
     * @param channelRelCondition
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException ResultMessage
     */
    @RequestMapping(value = "/queryPageData", method = RequestMethod.GET)
    public ResultMessage queryPageData(ChannelRelCondition channelRelCondition)
            throws InstantiationException, IllegalAccessException {
        logger.info("selectPageList param: " + JSON.toJSONString(channelRelCondition));
        Page<ParkChannelRel> page = parkChannelRelServiceImpl.selectPageList(channelRelCondition);
        PageVo<ChannelRelVo> pageVO = new PageVo<>(page, ChannelRelVo.class);
        return ResultMessage.createSuccessResult(pageVO);
    }

    /**
     * 删除车场通道绑定
     * 
     * @param ids
     * @return ResultMessage
     */
    @RequestMapping(value = "/batchDeleteParkChannelRels", method = RequestMethod.GET)
    public ResultMessage deleteParkChannelRels(@RequestParam(value = "ids") List<String> ids) {
        logger.info("batchDeleteParkChannelRels param: " + JSON.toJSONString(ids));
        parkChannelRelServiceImpl.deleteByIds(ids);
        return ResultMessage.createSuccessResult(null);
    }

    /**
     * 更新车场通道绑定
     * 
     * @param channelRelVo
     * @return ResultMessage
     */
    @RequestMapping(value = "/updateChannelRel", method = RequestMethod.POST)
    public ResultMessage updateChannelRel(@Valid @RequestBody ChannelRelVo channelRelVo) {
        logger.info("updateChannelRel param: " + JSON.toJSONString(channelRelVo));
        ParkChannelRel parkChannelRel = channelRelVo.convertVOToPO();
        parkChannelRelServiceImpl.update(parkChannelRel);
        return ResultMessage.createSuccessResult(null);
    }
}
