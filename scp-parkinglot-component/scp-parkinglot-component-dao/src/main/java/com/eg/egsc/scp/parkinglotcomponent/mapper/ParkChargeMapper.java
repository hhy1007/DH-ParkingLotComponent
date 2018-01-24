package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCharge;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkChargeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkChargeMapper {
    int countByExample(ParkChargeCriteria example);

    int deleteByExample(ParkChargeCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkCharge record);

    int insertSelective(ParkCharge record);

    List<ParkCharge> selectByExampleWithRowbounds(ParkChargeCriteria example, RowBounds rowBounds);

    List<ParkCharge> selectByExample(ParkChargeCriteria example);

    ParkCharge selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkCharge record, @Param("example") ParkChargeCriteria example);

    int updateByExample(@Param("record") ParkCharge record, @Param("example") ParkChargeCriteria example);

    int updateByPrimaryKeySelective(ParkCharge record);

    int updateByPrimaryKey(ParkCharge record);
}