/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus;

/**
 * 0、1标记
 * 
 * @Class Name BaseFlag
 * @Author zhangli
 * @Create In 2017年12月19日
 */
public enum BaseFlag {
	
    YES(1, "yes"),
    
    NO(0, "no");
    
    private Integer type;
    
    private String desc;
    
    private BaseFlag (Integer type, String desc){
    	this.type = type;
    	this.desc = desc;
    }

   public static BaseFlag getEnum(Integer type){
		for(BaseFlag zeroOneFlag : BaseFlag.values()){
			if(zeroOneFlag.getType().intValue() == type){
				return zeroOneFlag;
			}
		}
		return NO;
	}
    
	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
}
