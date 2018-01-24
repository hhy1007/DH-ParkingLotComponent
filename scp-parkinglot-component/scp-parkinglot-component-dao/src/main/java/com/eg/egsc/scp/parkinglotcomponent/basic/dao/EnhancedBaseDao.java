/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eg.egsc.framework.dao.base.BaseDao;
import com.eg.egsc.framework.paging.PageUtils;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.Page;
import com.eg.egsc.scp.parkinglotcomponent.basic.page.PageRequest;
import com.eg.egsc.scp.parkinglotcomponent.basic.util.EnhancedReflectionUtils;

/**
 * dao基类
 * 
 * @Class Name EnhancedBaseDao
 * @Author zhangli
 * @Create In 2017年12月14日
 * @param <M>
 * @param <M1>
 * @param <E>
 */
public abstract class EnhancedBaseDao<M, M1, E> extends BaseDao<M, M1, E> {
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询条数接口名
     * 
     * @Field String COUNT_BY_EXAMPLE 
     */
    private static final String COUNT_BY_EXAMPLE = "countByExample";

    /**
     * 支持分页查询详情的接口名
     * 
     * @Field String SELECT_BY_EXAMPLE_WITH_ROWBOUNDS 
     */
    private static final String SELECT_BY_EXAMPLE_WITH_ROWBOUNDS = "selectByExampleWithRowbounds";
    
    /**
     * 自定义mapper
     * 
     * @Field Class<?> customMapper 
     */
    protected Class<?> customMapper;

    public void setCustomMapper(Class<?> customMapper) {
        this.customMapper = customMapper;
    }

    public Object getCustomMapper() {
        return this.getSqlSession().getMapper(customMapper);
    }
    
    /**
     * 分页查询
     * 
     * @Methods Name selectPageList
     * @Create In 2017年12月15日 By zhangli
     * @param duc
     * @param pageRequest
     * @return Page<T>
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> Page<T> selectPageList(Object duc, PageRequest pageRequest) {
        M mapper = this.getMapper();
        int totalCount = Integer.parseInt(String.valueOf(EnhancedReflectionUtils
                .invokeMethod(mapper, COUNT_BY_EXAMPLE, duc)));
        if (totalCount <= 0) {
            return new Page<>(pageRequest, 0);
        }
        List<T> list = null;
        if (totalCount > 0 && pageRequest.getPageSize() > 0) {
            RowBounds rowBounds = new RowBounds(
                    PageUtils.getOffset(pageRequest.getCurrentPage(), pageRequest.getPageSize()),
                    PageUtils.getLimit(pageRequest.getPageSize()));
            list = (List<T>) EnhancedReflectionUtils.invokeMethod(mapper,
                    SELECT_BY_EXAMPLE_WITH_ROWBOUNDS, duc, rowBounds);
        }
        if (totalCount <= (pageRequest.getCurrentPage() - 1) * pageRequest.getPageSize()) {
            list = new ArrayList<>(0);
        }
        return new Page<>(pageRequest, totalCount, list);
    }

    /**
     * 自定义sql脚本分页查询
     * 
     * @Methods Name selectCustomSqlPageList
     * @Create In 2017年12月15日 By zhangli
     * @param pageRequest
     * @return Page<T>
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> Page<T> selectCustomSqlPageList(PageRequest pageRequest) {
        Object mapper = this.getCustomMapper();
        if (mapper == null) {
            logger.error("customMapper is null*");
            return new Page<>(pageRequest, 0);
        }
        int totalCount = Integer.parseInt(String.valueOf(EnhancedReflectionUtils.invokeMethod(mapper, 
                COUNT_BY_EXAMPLE, pageRequest.getFilters())));
        if (totalCount <= 0) {
            return new Page<>(pageRequest, 0);
        }
        List<T> list = null;
        if (totalCount > 0 && pageRequest.getPageSize() > 0) {
            list = (List<T>) EnhancedReflectionUtils.invokeMethod(mapper,
                    SELECT_BY_EXAMPLE_WITH_ROWBOUNDS, pageRequest.getFilters());
        }
        if (totalCount <= (pageRequest.getCurrentPage() - 1) * pageRequest.getPageSize()) {
            list = new ArrayList<>(0);
        }
        return new Page<>(pageRequest, totalCount, list);
    }

}

