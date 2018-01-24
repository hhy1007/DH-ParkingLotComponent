/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.web.demo;

import java.io.Serializable;

/**
 * @Class Name UserBean
 * @Author zhangli
 * @Create In 2018年1月3日
 */
public class UserBean implements Serializable{
    
    /**
     * @Field long serialVersionUID 
     */
    private static final long serialVersionUID = 6348929439014579464L;
    
    /**
     * 姓名
     * @Field String name 
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
