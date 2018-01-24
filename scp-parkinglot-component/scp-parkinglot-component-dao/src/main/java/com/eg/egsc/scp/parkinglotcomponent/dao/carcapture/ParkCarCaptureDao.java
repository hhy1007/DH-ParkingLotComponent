/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.dao.carcapture;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.eg.egsc.scp.parkinglotcomponent.basic.dao.EnhancedBaseDao;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.condition.carcapture.CarCaptureCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarCaptureMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCapture;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarCaptureCriteria;

/**
 * 抓拍记录持久层接口
 * 
 * @Class Name AccesscurDao
 * @Author xiangdaoping
 * @Create In 2017年12月15日
 */
@Repository
public class ParkCarCaptureDao
        extends EnhancedBaseDao<ParkCarCaptureMapper, ParkCarCaptureMapper, ParkCarCapture> {

    @Override
    protected void setMapperClass() {
        this.setMapperClass(ParkCarCaptureMapper.class);
        this.setExtMapperClass(ParkCarCaptureMapper.class);
    }

    @Override
    protected void setEntityClass() {
        this.setEntityClass(ParkCarCapture.class);

    }

    /**
     * 分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月15日 By xiangdaoping
     * @param pageRequest
     * @return Page<ParkCarCapture>
     */
    public Page<ParkCarCapture> selectPageList(PageRequest<CarCaptureCondition> pageRequest) {

        ParkCarCaptureCriteria duc = this.getBaseCriteria(pageRequest.getFilters());
        return super.selectPageList(duc, pageRequest);
    }


    /**
     * 查询抓拍记录信息
     * 
     * @Methods Name selectList
     * @Create In 2017年12月14日 By xiangdaoping
     * @param condition
     * @return int
     */
    public List<ParkCarCapture> selectList(CarCaptureCondition condition) {
        ParkCarCaptureCriteria duc = this.getBaseCriteria(condition);
        return this.getMapper().selectByExample(duc);
    }

    /**
     * 自定义过滤条件
     * 
     * @Methods Name ParkAccessCurCriteria
     * @Create In 2017年12月15日 By xiangdaoping
     * @param condition
     * @return ParkCarCriteria
     */
    public ParkCarCaptureCriteria getBaseCriteria(CarCaptureCondition condition) {
        ParkCarCaptureCriteria duc = new ParkCarCaptureCriteria();
        ParkCarCaptureCriteria.Criteria ducc = duc.createCriteria();
        if (StringUtils.isNotBlank(condition.getId())) {
            ducc.andUuidEqualTo(condition.getId());
        }
        if (StringUtils.isNotBlank(condition.getCarNum())) {
            ducc.andCarNumEqualTo(condition.getCarNum());
        }
        if (condition.getCapTime() != null) {
            ducc.andCreateTimeEqualTo(condition.getCapTime());
        }
        if (StringUtils.isNotBlank(condition.getChannelId())) {
            ducc.andChannelIdEqualTo(condition.getChannelId());
        }
        if (StringUtils.isNotBlank(condition.getCameraCode())) {
            ducc.andCameraCodeEqualTo(condition.getCameraCode());
        }
        if (StringUtils.isNotBlank(condition.getCameraName())) {
            ducc.andCameraNameEqualTo(condition.getCameraName());
        }
        if (StringUtils.isNotBlank(condition.getCarNumColor())) {
            ducc.andCarNumColorEqualTo(condition.getCarNumColor());
        }
        if (StringUtils.isNotBlank(condition.getCarMode())) {
            ducc.andCarModeEqualTo(condition.getCarMode());
        }
        if (StringUtils.isNotBlank(condition.getCarBrand())) {
            ducc.andCarBrandEqualTo(condition.getCarBrand());
        }
        return duc;
    }

}
