/**
 * @Probject Name: scp-parkinglot-component-service
 * @Path: com.eg.egsc.scp.parkinglotcomponent.enmus.authpackagePackageState.java
 * @Create By wangziqiang
 * @Create In 2018年1月22日 下午2:01:01
 */
package com.eg.egsc.scp.parkinglotcomponent.enmus.authpackage;

/**
 * 授权套餐状态
 * @Class Name PackageState
 * @Author wangziqiang
 * @Create In 2018年1月22日
 */
public enum PackageState {
    
    NOMALSTATE("enable","正常状态"),
    FROZENSTATE("frozen","冻结状态"),
    DOWNSTATE("disable","不可用") ; 
    
    private String type;
    
    private String desc;
    
    private PackageState(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
    
    public static PackageState getEnum(String type) {
        for (PackageState packageState : PackageState.values()) {
            if (packageState.getType().equals(type)) {
                return packageState;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
    
    
    
}
