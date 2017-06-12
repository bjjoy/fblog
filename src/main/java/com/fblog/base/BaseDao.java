package com.fblog.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
	public List<T> findAll();
    
    
    
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
    
    /**
     * 重找表中数据总数
     * @return Long
     */
	public Long findCount();
	
	 /**
     * 根据sql查询数据量
     * @return Long
     */
	public Long findCount(String paraSql);
	
	/**
     * @param paramSql
     * @return List<T>
     */
	public List<T> findSqlList(String paraSql);
	
	/**
	 * 分页查询
     * @param paramSql查询语句,startPage 起始页, pageSize 每页数据数
     * @return List<T>
     */
	public List<T> findSqlPage(String paraSql, int startPage, int pageSize);
	
	/**
	 * 分页查询
     * @param paramSql查询语句,startPage 起始页, pageSize 每页数据数
     * @return List<Map>
     */
	public List<Map<String,Object>> findSqlPageMap(String paraSql, int startPage, int pageSize);
}
