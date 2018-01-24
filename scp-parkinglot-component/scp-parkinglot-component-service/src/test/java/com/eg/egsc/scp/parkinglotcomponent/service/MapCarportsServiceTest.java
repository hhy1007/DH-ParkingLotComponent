package com.eg.egsc.scp.parkinglotcomponent.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.result.ResultMessage;
import com.eg.egsc.scp.parkinglotcomponent.condition.park.map.MapCarportsCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmAbnormal;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmArrear;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAlarmOccupy;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCarport;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkParkedCur;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.MapCarportsService;
import com.eg.egsc.scp.parkinglotcomponent.service.carport.map.dto.CarportsInfoDto;
import com.eg.egsc.scp.parkinglotcomponent.web.carport.map.MapCarportsController;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.map.MapCarportsVo;

/**
 * 地图展示车位使用测试类
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class MapCarportsServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MapCarportsService mapCarportsServiceImpl;

    @Autowired
    private MapCarportsController mapCarportsController;

    @Test
    @Transactional
    @Rollback(true)
    public void testControllerUpdateCarportslocation() {
        MapCarportsVo mapCarportsVo = new MapCarportsVo();
        mapCarportsVo.setCarportCode("hd000001");
        mapCarportsVo.setOnMap(0);
        try {
            ResultMessage result = mapCarportsController.updateCarportslocation(mapCarportsVo);
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testControllerListCarports() throws InstantiationException, IllegalAccessException {
        MapCarportsCondition condition = new MapCarportsCondition();
        condition.setMapId("100");
        condition.setMaxMapX(new BigDecimal(200));
        condition.setMaxMapY(new BigDecimal(300));
        try {
            ResultMessage page = mapCarportsController.listCarports(condition);
            logger.info("===" + page);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCarportslocation() {
        MapCarportsVo mapCarportsVo = new MapCarportsVo();
        mapCarportsVo.setCarportCode("hd000001");
        mapCarportsVo.setOnMap(1);
        mapCarportsVo.setMapId(111);
        mapCarportsVo.setMapX(new BigDecimal(88));
        mapCarportsVo.setMapY(new BigDecimal(288));
        try {
            int result = mapCarportsServiceImpl.updateCarportslocation(mapCarportsVo);
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testSelectPageList() {
        MapCarportsCondition condition = new MapCarportsCondition();
        condition.setMapId("100");
        condition.setMaxMapX(new BigDecimal(200));
        condition.setMaxMapY(new BigDecimal(300));
        try {
            Page<ParkCarport> page = mapCarportsServiceImpl.selectPageList(condition);
            logger.info("===" + page);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testParkingFeeCheck() {
        try {
            List<ParkAlarmArrear> parkingFeeCheckList = mapCarportsServiceImpl.parkingFeeCheck();
            logger.info("===" + parkingFeeCheckList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testReleaseParkAlarm() {
        ParkAlarmArrear parkAlarmArrear = new ParkAlarmArrear();
        parkAlarmArrear.setUuid("1");
        try {
            int result = mapCarportsServiceImpl.releaseParkAlarmArrear(parkAlarmArrear);
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Test
    public void testCountParkAlarm() {
        try {
            int result = mapCarportsServiceImpl.countParkAlarmArrear();
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testCarportOccupuiedCheck() {
        try {
            List<ParkAlarmOccupy> result = mapCarportsServiceImpl.carportOccupuiedCheck();
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testReleaseParkAlarmOccupy() {
        ParkAlarmOccupy parkAlarmOccupy = new ParkAlarmOccupy();
        parkAlarmOccupy.setUuid("1");
        try {
            int result = mapCarportsServiceImpl.releaseParkAlarmOccupy(parkAlarmOccupy);
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testCountParkAlarmOccupy() {
        try {
            int result = mapCarportsServiceImpl.countParkAlarmOccupy();
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testCarAbnormalcheck() {
        try {
            List<ParkAlarmAbnormal> list = mapCarportsServiceImpl.carAbnormalcheck();
            logger.info("===" + list);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testReleaseParkAlarmAbnormal() {
        ParkAlarmAbnormal parkAlarmAbnormal = new ParkAlarmAbnormal();
        parkAlarmAbnormal.setUuid("1");
        try {
            int result = mapCarportsServiceImpl.releaseParkAlarmAbnormal(parkAlarmAbnormal);
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testCountParkAlarmAbnormal() {
        try {
            int result = mapCarportsServiceImpl.countParkAlarmAbnormal();
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testSelectList() {
        try {
            List<ParkParkedCur> parkParkedCurList = mapCarportsServiceImpl.selectList();
            logger.info("===" + parkParkedCurList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testCountAllKindsCarport() {
        try {
            CarportsInfoDto result =
                    mapCarportsServiceImpl.countAllKindsCarport("9fc6b0874aca46da85dd6edb37c70a7b");
            logger.info("===" + result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
