/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.park.map;

import java.math.BigDecimal;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 地图展示车位信息查询过滤条件
 * 
 * @Class Name MapCarportsCondition
 * @Author huangzhiqiang
 * @Create In 2018年1月8日
 */
public class MapCarportsCondition extends PageCondition {

    private String mapId;// 地图ID

    private BigDecimal minMapX;// 最小地图横坐标

    private BigDecimal maxMapX;// 最大地图横坐标

    private BigDecimal minMapY;// 最小地图纵坐标

    private BigDecimal maxMapY;// 最大地图纵坐标

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public BigDecimal getMinMapX() {
        return minMapX;
    }

    public void setMinMapX(BigDecimal minMapX) {
        this.minMapX = minMapX;
    }

    public BigDecimal getMaxMapX() {
        return maxMapX;
    }

    public void setMaxMapX(BigDecimal maxMapX) {
        this.maxMapX = maxMapX;
    }

    public BigDecimal getMinMapY() {
        return minMapY;
    }

    public void setMinMapY(BigDecimal minMapY) {
        this.minMapY = minMapY;
    }

    public BigDecimal getMaxMapY() {
        return maxMapY;
    }

    public void setMaxMapY(BigDecimal maxMapY) {
        this.maxMapY = maxMapY;
    }

}
