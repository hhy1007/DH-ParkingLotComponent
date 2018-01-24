/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.extmapper.channel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.Channel;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.channel.entity.ChannelRel;

/**
 * 自定义sql语句(复杂的sql 或 多表关联查询是可自定义sql语句)
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ChannelMapper {

    /**
     * 根据parkingLotId查询停车场和车场通道信息
     * 
     * @param ids
     * @return List<Channel>
     */
    List<Channel> selectParkingLotAndChannel(List<String> ids);

    /**
     * 根据车场号和设备类型查询设备号
     * 
     * @param devType
     * @param parkCodes
     * @return List<ChannelRel>
     */
    List<ChannelRel> selectChannelByParkCodesAndDevType(@Param("devType") Short devType,
            @Param("parkCodes") List<String> parkCodes);
}
