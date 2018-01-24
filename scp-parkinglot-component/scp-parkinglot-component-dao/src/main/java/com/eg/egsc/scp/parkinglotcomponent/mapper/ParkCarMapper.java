package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkCarMapper {
    int countByExample(ParkCarCriteria example);

    int deleteByExample(ParkCarCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkCar record);

    int insertSelective(ParkCar record);

    List<ParkCar> selectByExampleWithRowbounds(ParkCarCriteria example, RowBounds rowBounds);

    List<ParkCar> selectByExample(ParkCarCriteria example);

    ParkCar selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkCar record, @Param("example") ParkCarCriteria example);

    int updateByExample(@Param("record") ParkCar record, @Param("example") ParkCarCriteria example);

    int updateByPrimaryKeySelective(ParkCar record);

    int updateByPrimaryKey(ParkCar record);
}