package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRel;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkPackageCarRelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkPackageCarRelMapper {
    int countByExample(ParkPackageCarRelCriteria example);

    int deleteByExample(ParkPackageCarRelCriteria example);

    int insert(ParkPackageCarRel record);

    int insertSelective(ParkPackageCarRel record);

    List<ParkPackageCarRel> selectByExampleWithRowbounds(ParkPackageCarRelCriteria example, RowBounds rowBounds);

    List<ParkPackageCarRel> selectByExample(ParkPackageCarRelCriteria example);

    int updateByExampleSelective(@Param("record") ParkPackageCarRel record, @Param("example") ParkPackageCarRelCriteria example);

    int updateByExample(@Param("record") ParkPackageCarRel record, @Param("example") ParkPackageCarRelCriteria example);
}