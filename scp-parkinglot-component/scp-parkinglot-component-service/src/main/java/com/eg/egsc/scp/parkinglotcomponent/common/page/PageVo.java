/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.common.page;

import java.util.ArrayList;
import java.util.List;

import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.common.vo.BaseConvert;

/**
 * 分页信息封装VO
 * 
 * @Class Name PageVo
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <T>
 */
public class PageVo<T>  {
	
    private List<T> pageData = new ArrayList<>();
	
	/** 当前页数*/
	private int currentPage;
	
	/** 总页数*/
	private int totalPage;
	
	/** 每页条数*/
	private int pageSize;
	
	/** 总行数*/
	private int totalRows;
	
	public PageVo(int pageSize,int currentPage,int totalRows){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRows   = totalRows;
		if(pageSize > 0){
			totalPage = totalRows%pageSize==0 ? totalRows/pageSize : totalRows/pageSize+1;
		}
	}
	
	public PageVo(Page<T> page){
		this.pageSize = page.getPageSize();
		this.currentPage = page.getCurrentPage();
		this.totalRows   = page.getTotalCount();
		this.pageData = page.getResult();
		if(pageSize > 0){
			totalPage = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		}
	}
	
	@SuppressWarnings("rawtypes")
    public PageVo(List poList,Class voType) throws InstantiationException, IllegalAccessException{
		if(poList!=null){
			this.totalPage   =1;		
			this.totalRows   = poList.size();		
			this.currentPage = 1;
			this.pageSize    = poList.size();
			BaseConvert.listPOToVO(poList, pageData, voType);
		}
		
	}
	
	@SuppressWarnings("rawtypes")
    public PageVo(Page page,Class voType) throws InstantiationException, IllegalAccessException{
		this(page.getPageSize(),page.getCurrentPage(),page.getTotalCount());
		BaseConvert.listPOToVO(page.getResult(), pageData, voType);
	}
	
	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRows() {
		return totalRows;
	}
}
