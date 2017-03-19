package com.fblog.user.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
	
	public List<User> findUserBySex(String sex){
		String sql="select * from user where sex ='"+sex+"'";
		return this.findSqlList(sql);
	}
}
