package com.fblog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fblog.base.impl.BaseServiceImpl;
import com.fblog.dao.UserDao;
import com.fblog.entity.User;
import com.fblog.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public void saveA(User user)throws Exception {
		this.userDao.saveA(user);
	}
	
	public List<Map<String,Object>> findUserByName(String name) throws Exception{
		return this.userDao.findUserByName(name);
	}
	
	public List<User> findUserBySex(String sex) throws Exception{
		return this.userDao.findUserBySex(sex);
	}

	public List<Map<String, Object>> findUserPage(User user, int startPage,
			int pageSize) {
		return this.userDao.findUserPage(user, startPage, pageSize);
	}
}
