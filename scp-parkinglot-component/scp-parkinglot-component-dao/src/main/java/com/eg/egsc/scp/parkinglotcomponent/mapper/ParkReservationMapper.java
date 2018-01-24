package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservation;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkReservationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkReservationMapper {
    int countByExample(ParkReservationCriteria example);

    int deleteByExample(ParkReservationCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkReservation record);

    int insertSelective(ParkReservation record);

    List<ParkReservation> selectByExampleWithRowbounds(ParkReservationCriteria example, RowBounds rowBounds);

    List<ParkReservation> selectByExample(ParkReservationCriteria example);

    ParkReservation selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkReservation record, @Param("example") ParkReservationCriteria example);

    int updateByExample(@Param("record") ParkReservation record, @Param("example") ParkReservationCriteria example);

    int updateByPrimaryKeySelective(ParkReservation record);

    int updateByPrimaryKey(ParkReservation record);
}