/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.channel;

import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.channel.ChannelRelCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;

/**
 * 车场通道绑定管理业务层接口
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public interface ParkChannelRelService {

    /**
     * 根据id查询车场通道绑定信息
     * 
     * @param uuid
     * @return ParkLedCarportRel
     */
    ParkChannelRel selectByPrimaryKey(String uuid);
    
    /**
     * 根据多个通道id查询通道绑定信息
     * 
     * @param channeIds
     * @return List<ParkChannelRel>
     */
    List<ParkChannelRel> selectChannelRelByIds(List<String> channeIds);

    /**
     * 添加车场通道绑定
     * 
     * @param parkChannelRel
     * @return int
     */
    int insert(ParkChannelRel parkChannelRel);

    /**
     * 更新车场通道绑定
     * 
     * @param parkChannelRel
     * @return int
     */
    int update(ParkChannelRel parkChannelRel);

    /**
     * 删除车场通道绑定
     * 
     * @param ids
     * @return int
     */
    int deleteByIds(List<String> ids);

    /**
     * 车场通道绑定信息分页查询
     * 
     * @param condition
     * @return Page<ParkChannelRel>
     */
    Page<ParkChannelRel> selectPageList(ChannelRelCondition condition);

    /**
     * 车场通道绑定信息查询
     * 
     * @param condition
     * @return List<ParkChannelRel>
     */
    List<ParkChannelRel> selectList(ChannelRelCondition condition);

    /**
     * 
     * 根据设备编号查询通道与设备绑定信息
     * 
     * @param devCode
     * @return List<ParkChannelRel>
     */
    List<ParkChannelRel> selectChannelRelByDevCode(String devCode);

    /**
     * 根据设备编号
     * 
     * @param devCode
     * @return int
     */
    int deleteByDevCode(String devCode);

}
