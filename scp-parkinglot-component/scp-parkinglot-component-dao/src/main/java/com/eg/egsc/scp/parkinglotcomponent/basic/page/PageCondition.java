/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.page;

/**
 * 分页条件
 * 
 * @Class Name PageCondition
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class PageCondition {

	public static final int MAX_PAGE_SIZE = 1000;
	
	private String singleCondition;
	
	private int currentPage = 1;
	
	private int pageSize = 20;
	
	private int pageOffset = 0;
	
	private String orderByClause;
	
	public String getSingleCondition() {
		return singleCondition;
	}
	
	public void setSingleCondition(String singleCondition) {
		singleCondition = singleCondition.replace("%", "\\%").replace("_", "\\_");
		this.singleCondition = singleCondition;
	}
	
	public int getCurrentPage() {
        return currentPage;
    }
	
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getPageSize() {
		return pageSize<=MAX_PAGE_SIZE ? pageSize : MAX_PAGE_SIZE;
	}
    
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
    public String getOrderByClause() {
        return orderByClause;
    }
    
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    public int getPageOffset() {
        this.pageOffset = ((this.getCurrentPage() -1) * this.getPageSize());
        return pageOffset;
    }
    
    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }
}
