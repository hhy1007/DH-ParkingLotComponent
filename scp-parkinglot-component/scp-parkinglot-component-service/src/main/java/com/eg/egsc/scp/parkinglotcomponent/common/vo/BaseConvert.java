/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.vo;

import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @Class Name BaseConvert
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class BaseConvert {
    
    private BaseConvert () {
    }
	
	public static void convertPOToVO(Object poObj, Object voObj) {
		BeanUtils.copyProperties(poObj, voObj);
	}
	
	public static void convertPOToVO(Object poObj, Object voObj, String...ignoreProperties) {
		BeanUtils.copyProperties(poObj, voObj, ignoreProperties);
	}
	
	public static void convertVOToPO(Object voObj, Object poObj) {
		BeanUtils.copyProperties(voObj, poObj);
	}
	
	public static void convertVOToPO(Object voObj, Object poObj, String...ignoreProperties) {
		BeanUtils.copyProperties(voObj, poObj, ignoreProperties);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void listVOToPO(List voList,List poList,Class poType) 
	    throws InstantiationException, IllegalAccessException{
		if(voList==null || poList==null){
			return;
		}
		
		for(Object obj : voList){
		  Object po = poType.newInstance();
		  convertVOToPO(obj,po);
		  poList.add(po);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void listPOToVO(List poList,List voList,Class voType) 
	    throws InstantiationException, IllegalAccessException{
		if(poList==null || voList==null){
			return;
		}
		
		for(Object obj : poList){
		  Object vo = voType.newInstance();
		  convertPOToVO(obj,vo);
		  voList.add(vo);
		}
	}
}
