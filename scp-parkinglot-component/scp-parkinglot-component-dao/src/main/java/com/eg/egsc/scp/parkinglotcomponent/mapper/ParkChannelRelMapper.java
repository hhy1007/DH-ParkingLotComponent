package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChannelRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkChannelRelMapper {
    int countByExample(ParkChannelRelCriteria example);

    int deleteByExample(ParkChannelRelCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkChannelRel record);

    int insertSelective(ParkChannelRel record);

    List<ParkChannelRel> selectByExampleWithRowbounds(ParkChannelRelCriteria example, RowBounds rowBounds);

    List<ParkChannelRel> selectByExample(ParkChannelRelCriteria example);

    ParkChannelRel selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkChannelRel record, @Param("example") ParkChannelRelCriteria example);

    int updateByExample(@Param("record") ParkChannelRel record, @Param("example") ParkChannelRelCriteria example);

    int updateByPrimaryKeySelective(ParkChannelRel record);

    int updateByPrimaryKey(ParkChannelRel record);
}