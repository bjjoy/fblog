package com.fblog.base.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fblog.base.BaseDao;
import com.fblog.base.BaseService;

@Service("baseService")
@Transactional
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>{

	@Resource
	private BaseDao<T,ID> baseDao;

	/**
     * The Entity class
     */
    private Class<T> entityClass;

    
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public T find(ID id) {
		return this.baseDao.find(id);
	}

	public List<T> findAll() {
		return this.baseDao.findAll();
	}

	public List<T> findList(ID... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(T entity) {
		this.baseDao.save(entity);
	}

	public void delete(ID... ids) {
		this.baseDao.remove(ids);
	}

	public void delete(T entity) {
		this.baseDao.delete(entity);
	}
	public Long findCount(){
		return this.baseDao.findCount();
	}
}
