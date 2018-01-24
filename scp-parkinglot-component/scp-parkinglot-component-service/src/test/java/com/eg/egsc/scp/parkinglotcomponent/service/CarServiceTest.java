/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.car.CarCondition;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkCar;
import com.eg.egsc.scp.parkinglotcomponent.service.car.CarService;
import com.eg.egsc.scp.parkinglotcomponent.service.car.dto.CarBatchOptDto;
import com.eg.egsc.scp.parkinglotcomponent.service.syscode.SysCodeService;

import junit.framework.TestCase;

/**
 * 车辆管理单例测试
 * 
 * @Class Name TestCarService
 * @Author zhangli
 * @Create In 2018年1月2日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class CarServiceTest extends TestCase{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource // 自动注入,默认按名称
    private CarService carServiceImpl;
    
    @Autowired
    private SysCodeService sysCodeServiceImpl;

    @Test
    @Transactional
    @Rollback(true)
    public void insertCar() {

        ParkCar car = new ParkCar();
        car.setCarNum("浙A22331");
        car.setCarBrand("1");
        car.setCarCode("1");
        car.setCarColor("1");
        car.setCarMode("1");
        car.setCarNumColor("2");
        car.setCarNumType((short) 1);
        car.setCreateUser("abcd");
        int result = carServiceImpl.insert(car);
        logger.info("=== " + result);
        logger.info("##id: " + car.getUuid());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void updateCar() {

        ParkCar car = new ParkCar();
        car.setUuid("e237c9c18c9f439582658ad5c9772ad6");
        car.setCarNum("粤B-111BB");
        car.setCarBrand("1");
        car.setCarCode("1");
        car.setCarColor("1");
        car.setCarMode("1");
        car.setCarNumColor("2");
        car.setCarNumType((short) 1);
        car.setUpdateTime(new Date());
        car.setUpdateUser("abcd");
        int result = carServiceImpl.update(car);
        logger.info("=== " + result);
        logger.info("##id: " + car.getUuid());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void batchDeleteCars() {

        List<String> ids = new ArrayList<>();
        ids.add("123");
        int result = carServiceImpl.deleteByIds(ids);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectPageList() {
        CarCondition carCondition = new CarCondition();
        carCondition.setPageSize(10);
        carCondition.setCurrentPage(1);
        Page<ParkCar> page = carServiceImpl.selectPageList(carCondition);
        logger.info("=== " + JSON.toJSONString(page));
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectById() {
        ParkCar result = carServiceImpl.selectById("Dkkwd");
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectByCarNum() {
        ParkCar result = carServiceImpl.selectByCarNum("阿Dkkwd");
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        CarCondition condition = new CarCondition();
        condition.setCarNum("f3392");
        List<ParkCar> result = carServiceImpl.selectList(condition);
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void updateStatus() {
        ParkCar parkCar = new ParkCar();
        parkCar.setCarBrand("3324");
        int result = carServiceImpl.updateStatus(parkCar);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectCarNumColorMap() {
        Map<String, String> result = sysCodeServiceImpl.getCarNumColorMap();
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectCarBrandMap() {
        Map<String, String> result = sysCodeServiceImpl.getCarBrandMap();
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectCarModeMap() {
        Map<String, String> result = sysCodeServiceImpl.getCarModeMap();
        logger.info("=== " + result);
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void selectCarColorMap() {
        Map<String, String> result = sysCodeServiceImpl.getCarColorMap();
        logger.info("=== " + result);
    }
    

    @Test
    @Transactional
    @Rollback(true)
    public void updateStatusByids() {
        CarBatchOptDto carBatchOptDto = new CarBatchOptDto();
        List<String> ids = new ArrayList<>();
        ids.add("123");
        ids.add("221");
        carBatchOptDto.setIds(ids);
        carBatchOptDto.setValidEndTime(new Date());
        carBatchOptDto.setValidStartTime(new Date());
        carBatchOptDto.setCarType((short) 1);
        carBatchOptDto.setMemo("332");
        int result = carServiceImpl.updateStatusByids(carBatchOptDto);
        logger.info("=== " + result);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void insertCarBatch() {

        List<ParkCar> cars = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            ParkCar car = new ParkCar();
            car.setCarNum("浙A2221"+i);
            car.setCarBrand("1");
            car.setCarCode("1");
            car.setCarColor("1");
            car.setCarMode("1");
            car.setCarNumColor("2");
            car.setCarNumType((short) 1);
            car.setCreateTime(new Date());
            car.setCreateUser("abcd");
            cars.add(car);
        }
        
        int result = carServiceImpl.insertCarBatch(cars);
        logger.info("=== " + result);
    }
    
}
