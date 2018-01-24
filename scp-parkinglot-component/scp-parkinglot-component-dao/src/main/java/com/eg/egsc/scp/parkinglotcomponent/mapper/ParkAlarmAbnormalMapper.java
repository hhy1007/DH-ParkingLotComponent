package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormal;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormalCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAlarmAbnormalMapper {
    int countByExample(ParkAlarmAbnormalCriteria example);

    int deleteByExample(ParkAlarmAbnormalCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAlarmAbnormal record);

    int insertSelective(ParkAlarmAbnormal record);

    List<ParkAlarmAbnormal> selectByExampleWithRowbounds(ParkAlarmAbnormalCriteria example, RowBounds rowBounds);

    List<ParkAlarmAbnormal> selectByExample(ParkAlarmAbnormalCriteria example);

    ParkAlarmAbnormal selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAlarmAbnormal record, @Param("example") ParkAlarmAbnormalCriteria example);

    int updateByExample(@Param("record") ParkAlarmAbnormal record, @Param("example") ParkAlarmAbnormalCriteria example);

    int updateByPrimaryKeySelective(ParkAlarmAbnormal record);

    int updateByPrimaryKey(ParkAlarmAbnormal record);
}