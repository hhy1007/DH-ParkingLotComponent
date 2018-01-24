/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.serviceParkAccessCurService.java
 * @Create By wangziqiang
 * @Create In 2018年1月15日 下午9:23:40
 */
package com.eg.egsc.scp.parkinglotcomponent.service;

import java.util.ArrayList;
import java.util.Date;
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

import com.alibaba.fastjson.JSONObject;
import com.eg.egsc.framework.client.core.ClientConfig;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.condition.access.AccessCurCondition;
import com.eg.egsc.scp.parkinglotcomponent.enmus.access.PayedMoney;
import com.eg.egsc.scp.parkinglotcomponent.enmus.alarm.CarType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarEnterMode;
import com.eg.egsc.scp.parkinglotcomponent.enmus.car.CarModeType;
import com.eg.egsc.scp.parkinglotcomponent.enmus.carport.CarportType;
import com.eg.egsc.scp.parkinglotcomponent.extmapper.access.entity.AccessCur;
import com.eg.egsc.scp.parkinglotcomponent.mapper.entity.ParkAccessCur;
import com.eg.egsc.scp.parkinglotcomponent.service.park.ParkAccessCurService;
import com.eg.egsc.scp.parkinglotcomponent.util.UuidUtil;
import com.eg.egsc.scp.parkinglotcomponent.web.vo.access.AccesscurVo;

/**
 * 在场车辆测试
 * 
 * @Class Name ParkAccessCurService
 * @Author wangziqiang
 * @Create In 2018年1月15日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClientConfig.class})
public class ParkAccessCurServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(ParkAccessCurServiceTest.class);

    @Autowired
    private ParkAccessCurService parkAccessCurServiceImpl;// 在场记录

    /**
     * 查询在场车辆
     * 
     * @Methods Name parkAccessCurServiceTest1
     * @Create In 2018年1月15日 By wangziqiang void
     */
    @Test
    @Transactional
    @Rollback(true)
    public void parkAccessCurServiceTest1() {

        try {
            AccessCur accessCur = parkAccessCurServiceImpl
                    .selectAccessCurAndParkingLotAndParkFeeRuleByPrimaryKey("2");
            logger.info("accessCur : " + JSONObject.toJSONString(accessCur));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        try {
            ParkAccessCur parkAccessCur1 = parkAccessCurServiceImpl.selectByPrimaryKey("2");
            logger.info("parkAccessCur1 : " + JSONObject.toJSONString(parkAccessCur1));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        AccessCurCondition condition = new AccessCurCondition();
        condition.setCurrentPage(0);
        condition.setPageSize(10);
        condition.setParkCode("HD001");
        try {
            Page<ParkAccessCur> list = parkAccessCurServiceImpl.selectPageList(condition);
            logger.info("list : " + JSONObject.toJSONString(list));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 插入在场车辆
     * 
     * @Methods Name parkAccessCurServiceTest2
     * @Create In 2018年1月15日 By wangziqiang void
     */
    @Test
    @Transactional
    @Rollback(true)
    public void parkAccessCurServiceTes2() {

        ParkAccessCur parkAccessCur = getParkAccessCur();
        new ParkAccessCur();
        try {
            int i = parkAccessCurServiceImpl.insert(parkAccessCur);
            logger.info("count2 : " + JSONObject.toJSONString(i));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 更新在场车辆
     * 
     * @Methods Name parkAccessCurServiceTest3
     * @Create In 2018年1月15日 By wangziqiang void
     */
    @Test
    @Transactional
    @Rollback(true)
    public void parkAccessCurServiceTes3() {

        ParkAccessCur parkAccessCur = getParkAccessCur();
        new ParkAccessCur();
        try {
            int i = parkAccessCurServiceImpl.update(parkAccessCur);
            logger.info("count3 : " + JSONObject.toJSONString(i));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 更新在场车辆
     * 
     * @Methods Name parkAccessCurServiceTest4
     * @Create In 2018年1月15日 By wangziqiang void
     */
    @Test
    @Transactional
    @Rollback(true)
    public void parkAccessCurServiceTes4() {

        try {
            List<String> ids = new ArrayList<>();
            ids.add("123123123123123123123");
            int i = parkAccessCurServiceImpl.deleteByIds(ids);
            logger.info("count4 : " + JSONObject.toJSONString(i));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * 得到ParkAccessCur
     * 
     * @Methods Name getParkAccessCur
     * @Create In 2018年1月15日 By wangziqiang
     * @return ParkAccessCur
     */
    private ParkAccessCur getParkAccessCur() {
        ParkAccessCur parkAccessCur = new ParkAccessCur();
        parkAccessCur.setCardNumber("");
        parkAccessCur.setCarMode("0");
        parkAccessCur.setCarportType((short) 0);
        parkAccessCur.setCarType((short) 0);
        parkAccessCur.setEnterMode((short) 0);
        parkAccessCur.setUuid("36456134645654613543132");
        parkAccessCur.setInCameraCode("222");
        parkAccessCur.setInChannelId("parkAccessCur");
        parkAccessCur.setInImgUrl("http://www.hscd.com/imgurl");
        parkAccessCur.setInNumUrl("http://www.hscd.com/numberurl");
        parkAccessCur.setInMemo("xxxxxxxxxxxxxxxxxxxxx");
        parkAccessCur.setCreateTime(new Date());
        parkAccessCur.setUpdateTime(new Date());
        parkAccessCur.setNeedPay((short) 0);
        parkAccessCur.setOwnerId("1101");
        parkAccessCur.setParkCode("HD001");
        parkAccessCur.setParkPackageId("a76dd685075e42758d099d748f0a98e3");
        parkAccessCur.setPayedMoney(20);
        return parkAccessCur;
    }


    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessCur() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setCarportType((short) 0);
        accessCur.setCarType((short) 0);
        accessCur.setEnterMode((short) 0);
        accessCur.setCardNumber("");
        accessCur.setCarMode("011");
        accessCur.setParkCode("HD0asd01");
        try {
            parkAccessCurServiceImpl.insert(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessCur1() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setInChannelId("asdfwwwe34781741");
        accessCur.setCarNum("x!@33##$$");
        accessCur.setParkCode("");
        try {
            parkAccessCurServiceImpl.insert(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertAccessCur2() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setCarNum("x!@3aawkfgh3");
        accessCur.setParkCode("HDXSWad");
        try {
            parkAccessCurServiceImpl.insert(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessCur1() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setParkCode("HDXSWaewerexd");
        accessCur.setCarNum("x!@awe33");
        try {
            parkAccessCurServiceImpl.update(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessCur2() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setUuid(UuidUtil.generate());
        accessCur.setParkCode("HDXS233Wad");
        try {
            parkAccessCurServiceImpl.update(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessCur3() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setUuid(UuidUtil.generate());
        accessCur.setCarNum("x!@adfa33rtyrteyt");
        try {
            parkAccessCurServiceImpl.update(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateAccessCur4() {
        ParkAccessCur accessCur = new ParkAccessCur();
        accessCur.setUuid(UuidUtil.generate());
        accessCur.setCarNum("x!@adfaaasd33");
        accessCur.setParkCode("HDXS233W5467456ad");
        try {
            parkAccessCurServiceImpl.update(accessCur);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testsSelectPageList() {
        AccessCurCondition condition = new AccessCurCondition();
        condition.setCardNumber("adfww3");
        condition.setCarNumFzzz("Bx");
        condition.setId(UuidUtil.generate());
        condition.setInTime(new Date());
        condition.setParkCode("HD0056756561");
        condition.setCarType(CarType.PASSENEGER.getType());
        condition.setEnterMode(CarEnterMode.MANUAL.getType());
        condition.setInCameraCode("asdwerwqz");
        try {
            parkAccessCurServiceImpl.selectPageList(condition);
            parkAccessCurServiceImpl.selectList(condition);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
    
    @Test
    public void testAccessCurVo() {
        AccesscurVo accesscurVo = new AccesscurVo();
        accesscurVo.setCarMode(CarModeType.getEnum("0").getType());
        accesscurVo.setCarType(CarType.getEnum((short)0).getType());
        accesscurVo.setEnterMode(CarEnterMode.getEnum((short)1).getType());
        accesscurVo.setInImgUrl("sadtqweruqwo23423");
        accesscurVo.setCreateTime(new Date());
        accesscurVo.setInChannelId(UuidUtil.generate());
        accesscurVo.setCarportType(CarportType.getEnum((short)0).getType());
        accesscurVo.convertPOToVO(new ParkAccessCur());
        accesscurVo.getInMemo();
        accesscurVo.setCarNum("5462234@$");
        accesscurVo.setCardNumber("asdqeriupkj");
        accesscurVo.setInCameraCode(UuidUtil.generate());
        accesscurVo.setOwnerId(UuidUtil.generate());
        accesscurVo.setUpdateTime(new Date());
        accesscurVo.setParkCode("dafrasdfqwer");
        accesscurVo.getCarportType();
        accesscurVo.getCourtUuid();
        accesscurVo.getCarType();
        accesscurVo.getCarMode();
        accesscurVo.setInMemo("poxadhfytuwgfew");
        accesscurVo.setPayedMoney(PayedMoney.getEnum(0).getType());
        accesscurVo.setUuid(UuidUtil.generate());
        accesscurVo.convertVOToPO();
        accesscurVo.setCourtUuid(UuidUtil.generate());
        accesscurVo.getCreateTime();
        accesscurVo.getInChannelId();
        accesscurVo.getEnterMode();
        accesscurVo.getInImgUrl();
        accesscurVo.getPayedMoney();
        accesscurVo.getUuid();
    }
}
