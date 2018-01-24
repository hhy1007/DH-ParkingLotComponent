/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.channel;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ChannelRelMapper {


    /**
     * 根据channelId删除车场通道绑定信息
     * 
     * @param channelId
     * @return int
     */
    int deleteByChannelRelId(String channelId);

    /**
     * 根据多个通道id查询通道绑定信息
     * 
     * @param channeIds
     * @return List<ParkChannelRel>
     */
    List<ParkChannelRel> selectChannelRelByIds(List<String> channeIds);
    
    /**
     * 根据多个id批量查询
     * 
     * @param ids
     * @return List<ParkChannelRel>
     */
    List<ParkChannelRel> selectByIds(List<String> ids);
}
