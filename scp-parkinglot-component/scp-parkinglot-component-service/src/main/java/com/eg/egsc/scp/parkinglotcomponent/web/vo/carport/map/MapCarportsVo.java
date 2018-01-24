/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.vo.carport.map;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 车位(地图展示使用)VO类
 * 
 * @author huangzhiqiang
 * @since 2018年1月12日
 */
public class MapCarportsVo implements Serializable {

    /**
     * @Field long serialVersionUID
     */
    private static final long serialVersionUID = 4183828922487848891L;

    private String carportCode;// 车位编号

    private int onMap;// 是否与地图绑定

    private long mapId;// 地图ID

    private BigDecimal mapX;// 地图横坐标

    private BigDecimal mapY;// 地图纵坐标

    private Date updateTime;// 修改时间

    /**
     * @Return the String carportCode
     */
    public String getCarportCode() {
        return carportCode;
    }

    /**
     * @Param String carportCode to set
     */
    public void setCarportCode(String carportCode) {
        this.carportCode = carportCode;
    }

    /**
     * @Return the int onMap
     */
    public int getOnMap() {
        return onMap;
    }

    /**
     * @Param int onMap to set
     */
    public void setOnMap(int onMap) {
        this.onMap = onMap;
    }

    /**
     * @Return the long mapId
     */
    public long getMapId() {
        return mapId;
    }

    /**
     * @Param long mapId to set
     */
    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    /**
     * @Return the BigDecimal mapX
     */
    public BigDecimal getMapX() {
        return mapX;
    }

    /**
     * @Param BigDecimal mapX to set
     */
    public void setMapX(BigDecimal mapX) {
        this.mapX = mapX;
    }

    /**
     * @Return the BigDecimal mapY
     */
    public BigDecimal getMapY() {
        return mapY;
    }

    /**
     * @Param BigDecimal mapY to set
     */
    public void setMapY(BigDecimal mapY) {
        this.mapY = mapY;
    }

    /**
     * @Return the Date updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @Param Date updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
