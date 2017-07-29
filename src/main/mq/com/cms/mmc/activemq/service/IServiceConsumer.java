package com.cms.mmc.activemq.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

public interface IServiceConsumer {

	 /**
     * 接收消息，spring配置默认destination
     */
	public TextMessage receive(Destination destination);
	 /**
     * 接收消息，指定destination队列消息
     */
	public TextMessage receive(String destination);
}
