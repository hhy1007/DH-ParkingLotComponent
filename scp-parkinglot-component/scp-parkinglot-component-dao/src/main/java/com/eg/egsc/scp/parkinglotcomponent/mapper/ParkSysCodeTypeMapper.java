package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCodeType;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkSysCodeTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkSysCodeTypeMapper {
    int countByExample(ParkSysCodeTypeCriteria example);

    int deleteByExample(ParkSysCodeTypeCriteria example);

    int deleteByPrimaryKey(String typeCode);

    int insert(ParkSysCodeType record);

    int insertSelective(ParkSysCodeType record);

    List<ParkSysCodeType> selectByExampleWithRowbounds(ParkSysCodeTypeCriteria example, RowBounds rowBounds);

    List<ParkSysCodeType> selectByExample(ParkSysCodeTypeCriteria example);

    ParkSysCodeType selectByPrimaryKey(String typeCode);

    int updateByExampleSelective(@Param("record") ParkSysCodeType record, @Param("example") ParkSysCodeTypeCriteria example);

    int updateByExample(@Param("record") ParkSysCodeType record, @Param("example") ParkSysCodeTypeCriteria example);

    int updateByPrimaryKeySelective(ParkSysCodeType record);

    int updateByPrimaryKey(ParkSysCodeType record);
}