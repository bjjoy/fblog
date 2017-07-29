package com.fblog.base.impl;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class BaseCron {

	public String outJson(Object o){
		return JSON.toJSONString(o);
	}
}
