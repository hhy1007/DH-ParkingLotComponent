/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus;

/**
 * 删除标记
 * 
 * @author huangyuhong
 * @since 2018年1月18日
 */
public enum DeleteFlag {

    NORMAL((short)0, "正常"),
    
    DELETE((short)1, "删除");
    
    private Short type;
    
    private String desc;
    
    private DeleteFlag (Short type, String desc){
        this.type = type;
        this.desc = desc;
    }

   public static DeleteFlag getEnum(Short type){
        for(DeleteFlag deleteFlag : DeleteFlag.values()){
            if(deleteFlag.getType().shortValue() == type){
                return deleteFlag;
            }
        }
        return null;
    }
    
    public Short getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
