/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.carport.map.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.SqlUtil;
import com.eg.egsc.scp.parkinglotcomponent.common.exception.ExceptionFactory;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.dao.authpackage.ParkAuthPackageDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.carport.map.MapCarportsDao;
import com.eg.egsc.scp.parkinglotcomponent.dao.parked.ParkedCurDao;
import com.eg.egsc.scp.parkinglotcomponent.enmus.DeleteFlag;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map.CarStatusType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map.MapCarportsAlarmType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map.OnMapType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map.ParkAlarmArrearType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.map.SecurityDispatchType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.carport.CarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.park.ParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmAbnormalMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmArrearMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkAlarmOccupyMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkCarportMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkedCurMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.ParkParkingLotMapper;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormal;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormalCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrear;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrearCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupy;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupyCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAuthPackage;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarportCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCurCriteria;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkingLot;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.MapCarportsService;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.dto.CarportsInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.util.ErrorCodeConstant;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.CarportVo;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.ParkedCurVo;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.map.MapCarportsVo;


/**
 * 地图展示车位使用业务实现类
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
@Service
public class MapCarportsServiceImpl implements MapCarportsService {

    private static final String ALARM_STATE = "alarm_state";

    @Autowired
    private CarportMapper carportMapper;// 数据库通用ext操作接口

    @Autowired
    private ParkParkedCurMapper parkParkedCurMapper;// (车位实时停车)数据库通用操作接口

    @Autowired
    private ParkingLotMapper parkingLotMapper;// 数据库通用ext操作接口

    @Autowired
    private MapCarportsDao mapCarportsDao;// 地图功能使用的车位管理持久化接口

    @Autowired
    private ParkAlarmArrearMapper parkAlarmArrearMapper;// (车位欠费预警)数据库通用操作接口

    @Autowired
    private ParkAlarmOccupyMapper parkAlarmOccupyMapper;// (车位占用预警)数据库通用操作接口

    @Autowired
    private ParkAlarmAbnormalMapper parkAlarmAbnormalMapper;// (车辆异常)数据库通用操作接口

    @Autowired
    private ParkCarportMapper parkCarportMapper;// (车位信息)数据库通用操作接口

    @Autowired
    private ParkParkingLotMapper parkParkingLotMapper;// (停车场信息表)数据库通用操作接口

    @Autowired
    private ParkAuthPackageDao parkAuthPackageDao;// 授权套餐自定义mapper

    @Autowired
    private ParkedCurDao parkedCurDao;// 车位功能持久化接口

    @Override
    @Transactional
    public int updateCarportslocation(MapCarportsVo mapCarportsVo) {
        CarportVo portVo = new CarportVo();
        ParkedCurVo curVo = new ParkedCurVo();
        String portCode = mapCarportsVo.getCarportCode();
        int onMap = mapCarportsVo.getOnMap();
        long mapId = mapCarportsVo.getMapId();
        BigDecimal mapX = mapCarportsVo.getMapX();
        BigDecimal mapY = mapCarportsVo.getMapY();
        if (StringUtils.isBlank(portCode)) {// 判断车位编号是否为空,如果为空,抛出参数异常,结束业务
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        portVo.setCarportCode(portCode);
        curVo.setCarportCode(portCode);
        if (OnMapType.ONMAP.getType().intValue() == onMap) {// 绑定地图
            portVo.setMapId(String.valueOf(mapId));
            curVo.setMapId(String.valueOf(mapId));
            if (StringUtils.isBlank(mapX.toEngineeringString())) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
            portVo.setCarportCenterX(mapX);

            if (StringUtils.isBlank(mapY.toEngineeringString())) {
                throw ExceptionFactory
                        .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
            }
            portVo.setCarportCenterY(mapY);

        } else if (OnMapType.OUTOFMAP.getType().intValue() == onMap) {// 未绑定地图, mapId,mapX,mapY置空
            portVo.setMapId(null);//
            portVo.setCarportCenterX(null);
            portVo.setCarportCenterY(null);
            curVo.setMapId(null);
        }
        portVo.setUpdateTime(new Date());
        ParkCarport carRecord = portVo.convertVOToPO();
        ParkParkedCur curRecord = curVo.convertVOToPO();

        int rtn1 = carportMapper.updateByCode(carRecord);// park_carport
        int rtn2 = parkingLotMapper.updateByCode(curRecord);// park_parked_cur
        if (rtn1 == 0 || rtn2 == 0) {// 如果有一个未更新成功,回滚事务.
            throw ExceptionFactory.createSysException("parkinglot.carport.map.failure");
        }
        return 0;
    }

    @Override
    public Page<ParkCarport> selectPageList(MapCarportsCondition mapCarportCondition) {
        PageRequest<MapCarportsCondition> pageRequest = new PageRequest<>();
        pageRequest.setCurrentPage(mapCarportCondition.getCurrentPage());
        pageRequest.setPageSize(mapCarportCondition.getPageSize());
        pageRequest.setFilters(mapCarportCondition);
        return mapCarportsDao.selectPageList(pageRequest);
    }

    @Override
    public List<ParkAlarmArrear> parkingFeeCheck() {
        ParkAlarmArrearCriteria duc = new ParkAlarmArrearCriteria();
        duc.setOrderByClause(SqlUtil.orderDesc(ALARM_STATE));
        return parkAlarmArrearMapper.selectByExample(duc);
    }

    @Override
    @Transactional
    public int releaseParkAlarmArrear(ParkAlarmArrear parkAlarmArrear) {
        String id = parkAlarmArrear.getUuid();
        if (id == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        // 解除警报的需要设置更新缴费状态、预警信息、欠费清零、更新时间,同时更新车位实时停车的预警状态
        parkAlarmArrear.setChargeState(ParkAlarmArrearType.PAID.getType().shortValue());// 设置已缴费状态
        parkAlarmArrear.setAlarmState(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 设置解除预警状态
        parkAlarmArrear.setArrearAmount(0);// 欠费清零
        parkAlarmArrear.setUpdateTime(new Date());
        int rtn1 = parkAlarmArrearMapper.updateByPrimaryKeySelective(parkAlarmArrear);
        ParkAlarmArrear parkAlarmArrearCur = parkAlarmArrearMapper.selectByPrimaryKey(id);
        String carportCode = parkAlarmArrearCur.getCarportCode();
        ParkParkedCur parkParkedCur = new ParkParkedCur();
        parkParkedCur.setAlarmArrear(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 更新解除预警状态
        // 根据车位编号更新车位实时停车表的预警状态
        int rtn2 = parkedCurDao.updateAlarmByCarportCode(parkParkedCur, carportCode);
        if (rtn1 == 0 || rtn2 == 0) {// 如果有一个未更新成功,回滚事务.
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_PARKPARKEDCUR_ALARM_FAILURE);
        }
        return 0;
    }

    @Override
    public int countParkAlarmArrear() {
        ParkAlarmArrearCriteria duc = new ParkAlarmArrearCriteria();
        ParkAlarmArrearCriteria.Criteria ducc = duc.createCriteria();
        ducc.andAlarmStateEqualTo(MapCarportsAlarmType.WARNING.getType().shortValue());
        return parkAlarmArrearMapper.countByExample(duc);
    }

    @Override
    public List<ParkAlarmOccupy> carportOccupuiedCheck() {
        ParkAlarmOccupyCriteria duc = new ParkAlarmOccupyCriteria();
        duc.setOrderByClause(SqlUtil.orderDesc(ALARM_STATE));
        // 车位占用预警查询标准先不定义条件,视地图应用确定需要显示什么数据再定义
        return parkAlarmOccupyMapper.selectByExample(duc);
    }

    @Override
    @Transactional
    public int releaseParkAlarmOccupy(ParkAlarmOccupy parkAlarmOccupy) {
        String id = parkAlarmOccupy.getUuid();
        if (id == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        parkAlarmOccupy.setUpdateTime(new Date());// 更新时间
        parkAlarmOccupy.setAlarmState(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 设置解除预警状态
        int rtn1 = parkAlarmOccupyMapper.updateByPrimaryKeySelective(parkAlarmOccupy);
        ParkAlarmOccupy parkAlarmOccupyCur = parkAlarmOccupyMapper.selectByPrimaryKey(id);
        String carportCode = parkAlarmOccupyCur.getCarportCode();
        ParkParkedCur parkParkedCur = new ParkParkedCur();
        parkParkedCur.setAlarmStatus(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 更新解除预警状态
        // 根据车位编号更新车位实时停车表的预警状态
        int rtn2 = parkedCurDao.updateAlarmByCarportCode(parkParkedCur, carportCode);
        if (rtn1 == 0 || rtn2 == 0) {// 如果有一个未更新成功,回滚事务.
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_PARKPARKEDCUR_ALARM_FAILURE);
        }
        return 0;
    }

    @Override
    public int countParkAlarmOccupy() {
        ParkAlarmOccupyCriteria duc = new ParkAlarmOccupyCriteria();
        ParkAlarmOccupyCriteria.Criteria ducc = duc.createCriteria();
        ducc.andAlarmStateEqualTo(MapCarportsAlarmType.WARNING.getType().shortValue());
        return parkAlarmOccupyMapper.countByExample(duc);
    }

    @Override
    public List<ParkAlarmAbnormal> carAbnormalcheck() {
        ParkAlarmAbnormalCriteria duc = new ParkAlarmAbnormalCriteria();
        duc.setOrderByClause(SqlUtil.orderDesc(ALARM_STATE));
        // 车辆异常预警查询标准先不定义条件,视地图应用确定需要显示什么数据再定义
        return parkAlarmAbnormalMapper.selectByExample(duc);
    }

    @Override
    @Transactional
    public int releaseParkAlarmAbnormal(ParkAlarmAbnormal parkAlarmAbnormal) {
        String id = parkAlarmAbnormal.getUuid();
        if (id == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        parkAlarmAbnormal.setUpdateTime(new Date());// 更新时间
        parkAlarmAbnormal.setDispatchState(SecurityDispatchType.DISPATCH.getType().shortValue());// 派遣保安状态:已派遣
        parkAlarmAbnormal.setAlarmState(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 设置解除预警
        int rtn1 = parkAlarmAbnormalMapper.updateByPrimaryKeySelective(parkAlarmAbnormal);
        ParkAlarmAbnormal parkAlarmAbnormalCur = parkAlarmAbnormalMapper.selectByPrimaryKey(id);
        String carportCode = parkAlarmAbnormalCur.getCarportcode();
        ParkParkedCur parkParkedCur = new ParkParkedCur();
        parkParkedCur.setAlarmAbnormal(MapCarportsAlarmType.RELEASEWARNING.getType().shortValue());// 更新解除预警状态
        // 根据车位编号更新车位实时停车表的预警状态
        int rtn2 = parkedCurDao.updateAlarmByCarportCode(parkParkedCur, carportCode);
        if (rtn1 == 0 || rtn2 == 0) {// 如果有一个未更新成功,回滚事务.
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_PARKPARKEDCUR_ALARM_FAILURE);
        }
        return 0;
    }

    @Override
    public int countParkAlarmAbnormal() {
        ParkAlarmAbnormalCriteria duc = new ParkAlarmAbnormalCriteria();
        ParkAlarmAbnormalCriteria.Criteria ducc = duc.createCriteria();
        ducc.andAlarmStateEqualTo(MapCarportsAlarmType.WARNING.getType());
        return parkAlarmAbnormalMapper.countByExample(duc);
    }

    @Override
    public List<ParkParkedCur> selectList() {
        ParkParkedCurCriteria duc = new ParkParkedCurCriteria();
        return parkParkedCurMapper.selectByExample(duc);
    }

    @Override
    public CarportsInfoDto countAllKindsCarport(String id) {
        CarportsInfoDto carportsInfoDto = new CarportsInfoDto();
        // 查询总车位数、 空余车位
        ParkParkingLot parkParkingLot = parkParkingLotMapper.selectByPrimaryKey(id);
        if (parkParkingLot == null) {
            throw ExceptionFactory
                    .createSysException(ErrorCodeConstant.PARKINGLOT_COMMON_PARAMETER);
        }
        carportsInfoDto.setTotal(String.valueOf(parkParkingLot.getTotal()));
        carportsInfoDto.setIdle(String.valueOf(parkParkingLot.getIdle()));

        // 查询固定车位、月保车位、临停车位、不可用车位
        ParkCarportCriteria parkCarportCriteria = new ParkCarportCriteria();
        ParkCarportCriteria.Criteria parkCarportCreateCriteria =
                parkCarportCriteria.createCriteria();
        parkCarportCreateCriteria.andParkIdEqualTo(id);
        parkCarportCreateCriteria.andDeleteFlagEqualTo(DeleteFlag.NORMAL.getType().shortValue());
        List<ParkCarport> parkCarportList = parkCarportMapper.selectByExample(parkCarportCriteria);
        List<String> carportCodeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(parkCarportList)) {
            for (ParkCarport carportCode : parkCarportList) {
                carportCodeList.add(carportCode.getCarportCode());
            }
        }
        List<ParkAuthPackage> authPackageList = null;
        List<ParkAlarmAbnormal> parkAlarmAbnormalList = null;
        List<ParkAlarmOccupy> parkAlarmOccupyList = null;
        List<ParkAlarmArrear> parkAlarmArrearList = null;
        if (CollectionUtils.isNotEmpty(carportCodeList)) {
            authPackageList =
                    parkAuthPackageDao.selectParkAuthPackageByCarportCodes(carportCodeList);
            // 根据车位编号查询正常车辆数
            ParkAlarmAbnormalCriteria parkAlarmAbnormalCriteria = new ParkAlarmAbnormalCriteria();
            ParkAlarmAbnormalCriteria.Criteria parkAlarmAbnormalCreateCriteria =
                    parkAlarmAbnormalCriteria.createCriteria();
            parkAlarmAbnormalCreateCriteria.andCarportcodeIn(carportCodeList);
            parkAlarmAbnormalList =
                    parkAlarmAbnormalMapper.selectByExample(parkAlarmAbnormalCriteria);
            // 根据车位编号查询车辆异常表找到违停车辆数
            ParkAlarmOccupyCriteria parkAlarmOccupyCriteria = new ParkAlarmOccupyCriteria();
            ParkAlarmOccupyCriteria.Criteria parkAlarmOccupyCreateCriteria =
                    parkAlarmOccupyCriteria.createCriteria();
            parkAlarmOccupyCreateCriteria.andCarportCodeIn(carportCodeList);
            parkAlarmOccupyList = parkAlarmOccupyMapper.selectByExample(parkAlarmOccupyCriteria);
            // 根据车位编号查询车辆欠费变找到将到期车位数和欠费车位数
            ParkAlarmArrearCriteria parkAlarmArrearCriteria = new ParkAlarmArrearCriteria();
            ParkAlarmArrearCriteria.Criteria parkAlarmArrearCreateCriteria =
                    parkAlarmArrearCriteria.createCriteria();
            parkAlarmArrearCreateCriteria.andCarportCodeIn(carportCodeList);
            parkAlarmArrearList = parkAlarmArrearMapper.selectByExample(parkAlarmArrearCriteria);
        }
        CarportsInfoDto carportsInfoDtoTemp1 = this
                .selectFixedCarportAndMonthInsuranceCarportAndTemParkCarportAndUnavailableCarport(
                        authPackageList, carportsInfoDto);
        CarportsInfoDto carportsInfoDtoTemp2 =
                this.selectIllegalCar(parkAlarmOccupyList, carportsInfoDtoTemp1);
        CarportsInfoDto carportsInfoDtoTemp3 =
                this.selectExpireCarportAndArrearCarport(parkAlarmArrearList, carportsInfoDtoTemp2);
        return this.selectNomalCar(parkAlarmAbnormalList, carportsInfoDtoTemp3);
    }

    /**
     * 封装正常车辆数
     * 
     * @param parkAlarmAbnormalList
     * @param carportsInfoDtoThird
     * @return CarportsInfoDto
     */
    private CarportsInfoDto selectNomalCar(List<ParkAlarmAbnormal> parkAlarmAbnormalList,
            CarportsInfoDto carportsInfoDto) {
        int nomalCar = 0;
        if (CollectionUtils.isNotEmpty(parkAlarmAbnormalList)) {
            for (ParkAlarmAbnormal parkAlarmAbnormal : parkAlarmAbnormalList) {
                if (parkAlarmAbnormal.getAlarmState() == CarStatusType.NOMAL.getType()
                        .shortValue()) {
                    nomalCar++;
                }
            }
        }
        carportsInfoDto.setNomalCar(String.valueOf(nomalCar));
        return carportsInfoDto;
    }

    /**
     * 封装固定车位、月保车位、临停车位、不可用车位
     * 
     * @param authPackageList
     * @param carportsInfoDto
     * @return CarportsInfoDto
     */
    private CarportsInfoDto selectFixedCarportAndMonthInsuranceCarportAndTemParkCarportAndUnavailableCarport(
            List<ParkAuthPackage> authPackageList, CarportsInfoDto carportsInfoDto) {
        int fixedCarport = 0;
        int monthInsuranceCarport = 0;
        int temParkCarport = 0;
        int unavailableCarport = 0;
        if (CollectionUtils.isNotEmpty(authPackageList)) {
            for (ParkAuthPackage authPackage : authPackageList) {
                if (authPackage.getCarportType() == CarportType.MONTHWARRANTY.getType()) {// 1:月租车位类型
                    monthInsuranceCarport++;
                } else if (authPackage.getCarportType() == CarportType.PROPERTYRIGHTS.getType()) {// 2:产权(固定)车位类型
                    fixedCarport++;
                } else if (authPackage.getCarportType() == CarportType.INTHEPARK.getType()) {// 0:临停车位类型
                    temParkCarport++;
                } else {
                    unavailableCarport++;// 其他归属于不可用类型
                }
            }
        }
        carportsInfoDto.setFixedCarport(String.valueOf(fixedCarport));
        carportsInfoDto.setMonthInsuranceCarport(String.valueOf(monthInsuranceCarport));
        carportsInfoDto.setTemParkCarport(String.valueOf(temParkCarport));
        carportsInfoDto.setUnavailableCarport(String.valueOf(unavailableCarport));
        return carportsInfoDto;
    }

    /**
     * 封装违停车辆数
     * 
     * @param parkAlarmOccupyList
     * @param carportsInfoDto
     * @return CarportsInfoDto
     */
    private CarportsInfoDto selectIllegalCar(List<ParkAlarmOccupy> parkAlarmOccupyList,
            CarportsInfoDto carportsInfoDto) {
        // 查询违停车辆数,并赋值
        int illegalCar = 0;
        if (CollectionUtils.isNotEmpty(parkAlarmOccupyList)) {
            for (ParkAlarmOccupy parkAlarmOccupy : parkAlarmOccupyList) {
                if (parkAlarmOccupy.getAlarmState() == CarStatusType.ILLEGAL.getType()
                        .shortValue()) {// 0:违停车辆
                    illegalCar++;
                }
            }
        }
        carportsInfoDto.setIllegalCar(String.valueOf(illegalCar));
        return carportsInfoDto;
    }

    /**
     * 封装将到期车位数,欠费车位数
     * 
     * @param parkAlarmArrearList
     * @param carportsInfoDto
     * @return CarportsInfoDto
     */
    private CarportsInfoDto selectExpireCarportAndArrearCarport(
            List<ParkAlarmArrear> parkAlarmArrearList, CarportsInfoDto carportsInfoDto) {
        // 查询将到期车位数,欠费车位数
        int expireCarport = 0;
        int arrearCarport = 0;
        if (CollectionUtils.isNotEmpty(parkAlarmArrearList)) {
            for (ParkAlarmArrear parkAlarmArrear : parkAlarmArrearList) {
                if (parkAlarmArrear.getAlarmState() == ParkAlarmArrearType.EXPIRE.getType()
                        .shortValue()) {// 0:将到期车位
                    expireCarport++;
                } else if (parkAlarmArrear.getAlarmState() == ParkAlarmArrearType.ARREAR.getType()
                        .shortValue()) {// 1:欠费车位
                    arrearCarport++;
                }
            }
        }
        carportsInfoDto.setExpireCarport(String.valueOf(expireCarport));
        carportsInfoDto.setArrearCarport(String.valueOf(arrearCarport));
        return carportsInfoDto;
    }

}
