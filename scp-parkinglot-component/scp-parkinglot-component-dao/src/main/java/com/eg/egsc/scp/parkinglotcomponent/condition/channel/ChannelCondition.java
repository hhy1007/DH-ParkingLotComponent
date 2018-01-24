/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.condition.channel;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageCondition;

/**
 * 车场通道信息查询过滤条件
 * 
 * @author fengrongjun
 * @since 2018年1月12日
 */
public class ChannelCondition extends PageCondition {
    private String id;

    private String name;// 车道名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
