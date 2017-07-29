package com.fblog.dao;

import java.util.List;
import java.util.Map;

import com.fblog.base.BaseDao;
import com.fblog.entity.User;

public interface UserDao extends BaseDao<User, String>{

	public void saveA(User user);
	
	/**
	 * 根据name查找用户
	 */
	public List<Map<String,Object>> findUserByName(String name);
	
	public List<User> findUserBySex(String sex);
	
	public List<Map<String,Object>> findUserPage(User user, int startPage, int pageSize);
}
