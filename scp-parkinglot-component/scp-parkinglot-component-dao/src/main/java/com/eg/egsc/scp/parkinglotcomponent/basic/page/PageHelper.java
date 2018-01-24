/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * @Class Name PageHelper
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class PageHelper {

	private PageHelper() {
	}

	/**
	 * 得到第一条查询记录索引
	 * 
	 * @Methods Name getFirstResult
	 * @Create In 2018年1月8日 By zhangli
	 * @param pageNumber
	 * @param pageSize
	 * @return int
	 */
	public static int getFirstResult(int pageNumber, int pageSize) {
		if (pageSize <= 0)
			throw new IllegalArgumentException(
					"[pageSize] must great than zero");
		return (pageNumber - 1) * pageSize;
	}

	/**
	 * 计算总页数
	 * 
	 * @Methods Name computeLastPageNumber
	 * @Create In 2018年1月8日 By zhangli
	 * @param totalElements
	 * @param pageSize
	 * @return int
	 */
	public static int computeLastPageNumber(int totalElements, int pageSize) {
		int result = totalElements % pageSize == 0 ? totalElements / pageSize
				: totalElements / pageSize + 1;
		if (result <= 1)
			result = 1;
		return result;
	}

	/**
	 * 计算总页数
	 * @Methods Name computePageNumber
	 * @Create In 2018年1月8日 By zhangli
	 * @param pageNumber
	 * @param pageSize
	 * @param totalElements
	 * @return int
	 */
	public static int computePageNumber(int pageNumber, int pageSize,
			int totalElements) {
		if (pageNumber <= 1) {
			return 1;
		}
		if (Integer.MAX_VALUE == pageNumber
				|| pageNumber > computeLastPageNumber(totalElements, pageSize)) { // last
			return computeLastPageNumber(totalElements, pageSize);
		}
		return pageNumber;
	}
	
	/**
	 * 根据List 返回当前页结果
	 * 
	 * @Methods Name getResult
	 * @Create In 2018年1月8日 By zhangli
	 * @param pageNumber
	 * @param pageSize
	 * @param dataList
	 * @return List<?>
	 */
	public static List<Object> getResult(int pageNumber, int pageSize,List<?> dataList) {
		if(CollectionUtils.isEmpty(dataList)){
			return new ArrayList<>(0);
		}
		List<Object> result = new ArrayList<>() ; 
		int len = dataList.size();
		int minValue = (pageNumber-1)*pageSize ; 
		int maxValue = (pageNumber-1)*pageSize+pageSize ; 
		if(maxValue>len){
			maxValue = len ; 
		}
		for(int i = minValue; i<maxValue ;i++){
			result.add(dataList.get(i)) ; 
		}
		return result ; 
	}
	
	/**
	 * 构建page类
	 * 
	 * @Methods Name createPage
	 * @Create In 2018年1月8日 By zhangli
	 * @param pageRequest
	 * @param list
	 * @param totalCount
	 * @return Page<T>
	 */
	public static<T> Page<T> createPage(PageRequest<?> pageRequest, List<T> list, int totalCount){
        if (totalCount <= 0) {
            return new Page<>(pageRequest, 0);
        }
        if(totalCount <= (pageRequest.getCurrentPage()-1) * pageRequest.getPageSize()){
            return new Page<>(pageRequest.getCurrentPage(), pageRequest.getPageSize(), 
                    totalCount, new ArrayList<>(0));
        }
        Page<T> page = new Page<>(pageRequest, totalCount);
        if(pageRequest.getPageSize() > 0){
            page.setResult(list);
        }
        return page;
	}
}
