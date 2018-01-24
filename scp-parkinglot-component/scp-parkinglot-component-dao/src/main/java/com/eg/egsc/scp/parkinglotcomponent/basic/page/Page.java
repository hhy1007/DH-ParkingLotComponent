/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 分页信息封装
 * 
 * @Class Name Page
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <T>
 */
public class Page<T> implements Iterable<T> {

    protected List<T> result;

    /** 每页条数*/
	protected int pageSize;

	/** 当前页数*/
	protected int currentPage;

	/** 总行数*/
    protected int totalCount;
    
	public Page() {
	}

	@SuppressWarnings("rawtypes")
    public Page(PageRequest p, int totalCount) {
	    this(p.getCurrentPage(), p.getPageSize(), totalCount);
	}
	
	@SuppressWarnings("rawtypes")
	public Page(PageRequest p, int totalCount, List<T> result) {
        this(p.getCurrentPage(), p.getPageSize(), totalCount, result);
    }

	public Page(int pageNumber, int pageSize, int totalCount) {
		this(pageNumber, pageSize, totalCount, new ArrayList<>(0));
	}

	public Page(int pageNumber, int pageSize, int totalCount, List<T> result) {
		if (pageSize < 0) {
			throw new IllegalArgumentException(
					"[pageSize] must great than zero");
		}
		this.pageSize = pageSize;
		this.currentPage = PageHelper.computePageNumber(pageNumber, pageSize, totalCount);
		this.totalCount = totalCount;
		setResult(result);
	}

	public void setResult(List<T> elements) {
		if (elements == null)
			throw new IllegalArgumentException("'result' must be not null");
		this.result = elements;
	}

	/**
	 * 当前页包含的数据
	 * 
	 * @Methods Name getResult
	 * @Create In 2018年1月8日 By zhangli
	 * @return List<T>
	 */
	public List<T> getResult() {

		return result;
	}

	/**
	 * 是否是首页（第一页），第一页页码为1
	 * 
	 * @Methods Name isFirstPage
	 * @Create In 2018年1月8日 By zhangli
	 * @return boolean
	 */
	public boolean isFirstPage() {
		return this.getCurrentPage() == 1;
	}

	/**
	 * 是否是最后一页
	 * 
	 * @Methods Name isLastPage
	 * @Create In 2018年1月8日 By zhangli
	 * @return boolean
	 */
	public boolean isLastPage() {

		return this.getCurrentPage() >= getLastPageNumber();
	}

	/**
	 * 是否有下一页
	 * 
	 * @Methods Name isHasNextPage
	 * @Create In 2018年1月8日 By zhangli
	 * @return boolean
	 */
	public boolean isHasNextPage() {

		return getLastPageNumber() > this.getCurrentPage();
	}

	/**
	 * 是否有上一页
	 * 
	 * @Methods Name isHasPreviousPage
	 * @Create In 2018年1月8日 By zhangli
	 * @return boolean
	 */
	public boolean isHasPreviousPage() {
		return this.getCurrentPage() > 1;
	}

	/**
	 * 获取最后一页页码，也就是总页数
	 * 
	 * @Methods Name getLastPageNumber
	 * @Create In 2018年1月8日 By zhangli
	 * @return int
	 */
	public int getLastPageNumber() {
		return PageHelper.computeLastPageNumber(totalCount, pageSize);
	}

	/**
	 * 总的数据条目数量，0表示没有数据
	 * 
	 * @Methods Name getTotalCount
	 * @Create In 2018年1月8日 By zhangli
	 * @return int
	 */
	public int getTotalCount() {

		return totalCount;
	}

	/**
	 * 获取当前页的首条数据的行编码
	 * 
	 * @Methods Name getThisPageFirstElementNumber
	 * @Create In 2018年1月8日 By zhangli
	 * @return int
	 */
	public int getThisPageFirstElementNumber() {
		return (this.getCurrentPage() - 1) * getPageSize() + 1;
	}

	/**
	 * 获取当前页的末条数据的行编码
	 * 
	 * @Methods Name getThisPageLastElementNumber
	 * @Create In 2018年1月8日 By zhangli
	 * @return int
	 */
	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalCount() < fullPage ? getTotalCount() : fullPage;
	}

	public int getNextPageNumber() {

		return this.getCurrentPage() + 1;
	}

	public int getPreviousPageNumber() {
		return this.getCurrentPage() - 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

	/**
	 * 得到数据库的第一条记录号
	 * 
	 * @Methods Name getFirstResult
	 * @Create In 2018年1月8日 By zhangli
	 * @return int
	 */
	public int getFirstResult() {
		return PageHelper.getFirstResult(this.getCurrentPage(), pageSize);
	}

	@SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
		return  (result == null ? (Iterator<T>)Collections.emptyList()
				.iterator() : result.iterator());
	}


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
