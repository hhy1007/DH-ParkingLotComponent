package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfig;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkSysConfigMapper {
    int countByExample(ParkSysConfigCriteria example);

    int deleteByExample(ParkSysConfigCriteria example);

    int deleteByPrimaryKey(String configType);

    int insert(ParkSysConfig record);

    int insertSelective(ParkSysConfig record);

    List<ParkSysConfig> selectByExampleWithRowbounds(ParkSysConfigCriteria example, RowBounds rowBounds);

    List<ParkSysConfig> selectByExample(ParkSysConfigCriteria example);

    ParkSysConfig selectByPrimaryKey(String configType);

    int updateByExampleSelective(@Param("record") ParkSysConfig record, @Param("example") ParkSysConfigCriteria example);

    int updateByExample(@Param("record") ParkSysConfig record, @Param("example") ParkSysConfigCriteria example);

    int updateByPrimaryKeySelective(ParkSysConfig record);

    int updateByPrimaryKey(ParkSysConfig record);
}