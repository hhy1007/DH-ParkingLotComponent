/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.page;

/**
 * 分页查询请求信息
 * 
 * @Class Name PageRequest
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <T>
 */
public class PageRequest<T> {

	/**
	 * 过滤参数
	 * 
	 * @Field T filters 
	 */
	private T filters;

	/**
	 * 页号码,页码从1开始
	 * 
	 * @Field int currentPage 
	 */
	private int currentPage=1;

	/**
	 * 分页大小
	 * 
	 * @Field int pageSize 
	 */
	private int pageSize=20;
	
	public PageRequest() {

		this(0, 0, null);
	}

	public PageRequest(int pageNum, int pageSize) {
		this(pageNum, pageSize, null);
	}

	public PageRequest(int currentPage, int pageSize, T filters) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.filters = filters;
	}

	public T getFilters() {
		return filters;
	}

	public void setFilters(T filters) {
		this.filters = filters;
	}

	public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNumberAndSize(int start, int limit) {
		this.pageSize = limit;
		this.currentPage = start / limit;
	}

}
