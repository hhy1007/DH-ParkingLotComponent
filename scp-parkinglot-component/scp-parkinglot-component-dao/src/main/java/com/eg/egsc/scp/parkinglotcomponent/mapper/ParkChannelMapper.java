package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkChannelMapper {
    int countByExample(ParkChannelCriteria example);

    int deleteByExample(ParkChannelCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkChannel record);

    int insertSelective(ParkChannel record);

    List<ParkChannel> selectByExampleWithRowbounds(ParkChannelCriteria example, RowBounds rowBounds);

    List<ParkChannel> selectByExample(ParkChannelCriteria example);

    ParkChannel selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkChannel record, @Param("example") ParkChannelCriteria example);

    int updateByExample(@Param("record") ParkChannel record, @Param("example") ParkChannelCriteria example);

    int updateByPrimaryKeySelective(ParkChannel record);

    int updateByPrimaryKey(ParkChannel record);
}