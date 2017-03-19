package com.fblog.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

		/**
	    * Gets entity class.
	    *
	    * @return the entity class
	    */
	   public Class<T> getEntityClass();
	   
	   /**
	    * @param id
	    * @return T
	    */
	   public T find(ID id);

	   /**
	    *
	    * @return the list
	    */
	   public List<T> findAll();
	   
	   /**
	    *
	    * @param entity the entity
	    */
	   public void save(T entity);
	   
	   /**
	    * @param ids the ids
	    */
	   public void delete(ID... ids);

	   /**
	    * @param entity the entity
	    */
	   public void delete(T entity);
	   
	   /**
	    * @param entity
	    */
	   public Long findCount();
}
