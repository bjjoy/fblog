package com.cms.mmc.activemq.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cms.mmc.activemq.service.IServiceScheduled;

@Service("serviceScheduled")
public class ServiceScheduled implements IServiceScheduled{

//    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
//    @Override
	public void sendRedisMsg() {
//    	读取new表内容，每条发送到mq，删除，并放到old表
	}

}
