package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrear;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrearCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAlarmArrearMapper {
    int countByExample(ParkAlarmArrearCriteria example);

    int deleteByExample(ParkAlarmArrearCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAlarmArrear record);

    int insertSelective(ParkAlarmArrear record);

    List<ParkAlarmArrear> selectByExampleWithRowbounds(ParkAlarmArrearCriteria example, RowBounds rowBounds);

    List<ParkAlarmArrear> selectByExample(ParkAlarmArrearCriteria example);

    ParkAlarmArrear selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAlarmArrear record, @Param("example") ParkAlarmArrearCriteria example);

    int updateByExample(@Param("record") ParkAlarmArrear record, @Param("example") ParkAlarmArrearCriteria example);

    int updateByPrimaryKeySelective(ParkAlarmArrear record);

    int updateByPrimaryKey(ParkAlarmArrear record);
}