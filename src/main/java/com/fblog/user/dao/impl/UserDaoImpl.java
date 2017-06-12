package com.fblog.user.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fblog.base.impl.BaseDaoImpl;
import com.fblog.user.dao.UserDao;
import com.fblog.user.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public void saveA(User user){
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public List<Map<String,Object>> findUserByName(String name){
		String sql="select * from user where username like '%"+name+"%'";
		return this.findSqlListMap(sql);
	}
	@Transactional
	public List<User> findUserBySex(String sex){
		String sql="select * from user where sex ='"+sex+"'";
		return this.findSqlList(sql);
	}
	public List<Map<String,Object>> findUserPage(User user, int startPage, int pageSize){
		String sql="select * from user where 1=1";
		return this.findSqlPageMap(sql,startPage,pageSize);
	}
}
