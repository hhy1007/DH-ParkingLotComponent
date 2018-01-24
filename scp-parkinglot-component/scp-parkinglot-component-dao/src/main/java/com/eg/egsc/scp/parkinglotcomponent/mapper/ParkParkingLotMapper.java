package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLotCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkParkingLotMapper {
    int countByExample(ParkParkingLotCriteria example);

    int deleteByExample(ParkParkingLotCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkParkingLot record);

    int insertSelective(ParkParkingLot record);

    List<ParkParkingLot> selectByExampleWithRowbounds(ParkParkingLotCriteria example, RowBounds rowBounds);

    List<ParkParkingLot> selectByExample(ParkParkingLotCriteria example);

    ParkParkingLot selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkParkingLot record, @Param("example") ParkParkingLotCriteria example);

    int updateByExample(@Param("record") ParkParkingLot record, @Param("example") ParkParkingLotCriteria example);

    int updateByPrimaryKeySelective(ParkParkingLot record);

    int updateByPrimaryKey(ParkParkingLot record);
}