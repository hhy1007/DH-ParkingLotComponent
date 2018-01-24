/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.channel;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;

/**
 * 车场通道管理业务层接口实现
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkChannelService {

    /**
     * 根据id查询车场通道绑定信息
     * 
     * @param uuid
     * @return ParkChannelService
     */
    ParkChannel selectByPrimaryKey(String uuid);
    
    /**
     * 添加车场通道
     * 
     * @param parkChannel
     * @return int
     */
    int insert(ParkChannel parkChannel);

    /**
     * 更新车场通道
     * 
     * @param parkChannel
     * @return int
     */
    int update(ParkChannel parkChannel);

    /**
     * 删除车场通道
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 车场通道信息分页查询
     * 
     * @param condition
     * @return Page<ParkChannel>
     */
    Page<ParkChannel> selectPageList(ChannelCondition condition);

    /**
     * 车场通道信息查询
     * 
     * @param condition
     * @return List<ParkChannel>
     */
    List<ParkChannel> selectList(ChannelCondition condition);

}
