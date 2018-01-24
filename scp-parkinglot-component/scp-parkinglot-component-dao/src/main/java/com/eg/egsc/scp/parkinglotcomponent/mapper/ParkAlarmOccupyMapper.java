package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupy;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAlarmOccupyMapper {
    int countByExample(ParkAlarmOccupyCriteria example);

    int deleteByExample(ParkAlarmOccupyCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAlarmOccupy record);

    int insertSelective(ParkAlarmOccupy record);

    List<ParkAlarmOccupy> selectByExampleWithRowbounds(ParkAlarmOccupyCriteria example, RowBounds rowBounds);

    List<ParkAlarmOccupy> selectByExample(ParkAlarmOccupyCriteria example);

    ParkAlarmOccupy selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAlarmOccupy record, @Param("example") ParkAlarmOccupyCriteria example);

    int updateByExample(@Param("record") ParkAlarmOccupy record, @Param("example") ParkAlarmOccupyCriteria example);

    int updateByPrimaryKeySelective(ParkAlarmOccupy record);

    int updateByPrimaryKey(ParkAlarmOccupy record);
}