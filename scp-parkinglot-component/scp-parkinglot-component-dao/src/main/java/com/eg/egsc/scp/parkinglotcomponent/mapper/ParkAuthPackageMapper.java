package com.eg.egsc.scp.parkinglotcomponent.mapper;

import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackageCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ParkAuthPackageMapper {
    int countByExample(ParkAuthPackageCriteria example);

    int deleteByExample(ParkAuthPackageCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(ParkAuthPackage record);

    int insertSelective(ParkAuthPackage record);

    List<ParkAuthPackage> selectByExampleWithRowbounds(ParkAuthPackageCriteria example, RowBounds rowBounds);

    List<ParkAuthPackage> selectByExample(ParkAuthPackageCriteria example);

    ParkAuthPackage selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ParkAuthPackage record, @Param("example") ParkAuthPackageCriteria example);

    int updateByExample(@Param("record") ParkAuthPackage record, @Param("example") ParkAuthPackageCriteria example);

    int updateByPrimaryKeySelective(ParkAuthPackage record);

    int updateByPrimaryKey(ParkAuthPackage record);
}