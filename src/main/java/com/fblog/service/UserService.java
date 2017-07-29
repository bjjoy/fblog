package com.fblog.service;

import java.util.List;
import java.util.Map;

import com.fblog.base.BaseService;
import com.fblog.entity.User;

public interface UserService extends BaseService<User, String>{
	
	public void saveA(User user) throws Exception;
	
	public List<Map<String,Object>> findUserByName(String name) throws Exception;
	
	public List<User> findUserBySex(String sex) throws Exception;
	
	public List<Map<String,Object>> findUserPage(User user, int startPage, int pageSize);
}
