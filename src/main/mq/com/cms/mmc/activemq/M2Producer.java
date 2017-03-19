package com.cms.mmc.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.alibaba.fastjson.JSONObject;

//向mq发送2条数据
public class M2Producer {

	public M2Producer(){
		
	}
   
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("mssactivemq");

			MessageProducer producer = session.createProducer(destination);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("commKey", "send");
			jsonObject.put("id", "222");
			jsonObject.put("pId", "00ec55041f7c4534a4b6740b9187cf5d");
			jsonObject.put("key", "222_00ec55041f7c4534a4b6740b9187cf5d");
			jsonObject.put("items", "json对象");
			jsonObject.put("code", "equipment");
			for (int i = 0; i < 1; i++) {
				System.out.println("send...messageAA --->" + jsonObject);
				TextMessage message = session.createTextMessage(jsonObject.toJSONString());
				// 通过生产者发出消息
				producer.send(message);
			}
			
			
//			Session session2 = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
//			Destination destination2 = session2.createQueue("my-queue2");
//
//			MessageProducer producer2 = session2.createProducer(destination2);
//			for (int i = 0; i < 2; i++) {
//				TextMessage message = session2.createTextMessage("messageBB --->" + i);
//				System.out.println("send...messageBB --->" + i);
//				// 通过生产者发出消息
//				producer2.send(message);
//			}
			session.commit();
			session.close();
//			session2.commit();
//			session2.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
