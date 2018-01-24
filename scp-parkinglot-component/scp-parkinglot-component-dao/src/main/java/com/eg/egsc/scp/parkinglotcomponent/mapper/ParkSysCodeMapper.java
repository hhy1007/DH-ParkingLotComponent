package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCode;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCodeCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkSysCodeMapper {
    int countByExample(ParkSysCodeCriteria example);

    int deleteByExample(ParkSysCodeCriteria example);

    int deleteByPrimaryKey(ParkSysCodeKey key);

    int insert(ParkSysCode record);

    int insertSelective(ParkSysCode record);

    List<ParkSysCode> selectByExampleWithRowbounds(ParkSysCodeCriteria example, RowBounds rowBounds);

    List<ParkSysCode> selectByExample(ParkSysCodeCriteria example);

    ParkSysCode selectByPrimaryKey(ParkSysCodeKey key);

    int updateByExampleSelective(@Param("record") ParkSysCode record, @Param("example") ParkSysCodeCriteria example);

    int updateByExample(@Param("record") ParkSysCode record, @Param("example") ParkSysCodeCriteria example);

    int updateByPrimaryKeySelective(ParkSysCode record);

    int updateByPrimaryKey(ParkSysCode record);
}