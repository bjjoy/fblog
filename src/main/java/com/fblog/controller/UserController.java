package com.fblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fblog.base.impl.BaseCron;
import com.fblog.entity.User;
import com.fblog.service.UserService;

@Controller
@ResponseBody
@RequestMapping("/auth")
public class UserController extends BaseCron{

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping("/find")
	public Object find(User u){
//		String jsonStr = JSON.toJSONString(this.userService.findAll());
//		try {
//			this.userService.saveA(u);
//			this.userService.delete(u);
//			String lm = this.outJson(this.userService.findUserByName(u.getUserName()));
//			System.out.println(lm);
//			String lt = this.outJson(this.userService.findUserBySex(u.getSex()));
//			System.out.println(lt);
//			System.out.println(this.userService.findCount());
//			String[]a = {"1"};
//			this.userService.delete(a);
			JSONObject r = new JSONObject();
			r.put("r", this.userService.findAll());
			return r.toJSONString();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return jsonStr;
	}
	@RequestMapping("/findPage")
	public Object findPage(User user, int startPage, int pageSize){
//		String jsonStr = JSON.toJSONString(this.userService.findAll());
		try {
			JSONObject r = new JSONObject();
			r.put("r", this.userService.findUserPage(user, startPage, pageSize));
			return r.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
