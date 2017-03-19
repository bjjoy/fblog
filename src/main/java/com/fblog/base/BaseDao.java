package com.fblog.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,ID extends Serializable> {

	/**
     * 根据id查找实体
     *
     * @param T entity
     * @return T
     */
    public T find(ID id);
    
    /**
     * 查找所有entity
     *
     * @return List<T> entity list
     */
	List<T> findAll();
    
    
    
    /**
     * 插入entity
     *
     * @param entity
     */
    public void save(T entity);
    
    /**
     * 删除
     *
     * @param entity
     */
    public void delete(T entity);   
    
    /**
     * 批量删除
     *
     * @param entity
     */
    public void remove(ID... ids);
    
    
	public Long findCount();
	
	/**
     * @param paramSql
     * @return List<T>
     */
	public List<T> findSqlList(String paraSql);
}
