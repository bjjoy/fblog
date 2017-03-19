package com.fblog.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

import com.fblog.base.BaseDao;

public class BaseDaoImpl<T,ID extends Serializable> implements BaseDao<T,ID> {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = ((Class<T>) parameterizedType[0]);
	}
	
	@SuppressWarnings("unchecked")
	public T find(ID id) {
		return (T)this.sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String sql = "select * from "+entityClass.getSimpleName();
		return this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
	}

	public void save(T entity){
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	public void delete(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	public Long findCount() {
		String sql = "select count(*) num from "+entityClass.getSimpleName();
		Long num = Long.valueOf(this.sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult().toString());
		return num;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findSqlList(String paraSql) {
		return this.sessionFactory.getCurrentSession().createSQLQuery(paraSql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> findSqlListMap(String paraSql) {
		return this.sessionFactory.getCurrentSession().createSQLQuery(paraSql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
	}
	
	public void remove(ID... ids) {
		String sql = "delete from "+this.entityClass.getSimpleName()+" where id in(";
		for(ID id:ids){
			sql += id+",";
		}
		sql = sql.substring(0, sql.length()-1)+")";
		this.sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
}
