/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.vo;

/**
 * @Class Name BaseVo
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <PO>
 */
public interface BaseVo<P> {
  
	void convertPOToVO(P poObj);
	
	P convertVOToPO();
	
}

