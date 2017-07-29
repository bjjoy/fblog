package com.cms.mmc.activemq.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.cms.mmc.activemq.service.IServiceProducer;

//spring配置向队列发送消息
@Service("serviceProducer")
public class ServiceProducer implements IServiceProducer{

    @Resource(name="jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;
       
      /**
       * 向指定队列发送消息
       */
      public void sendMessage(String destination, final String msg) {
    	Destination d = new ActiveMQQueue(destination);
    	jmsQueueTemplate.send(d, new MessageCreator() {
          public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage(msg);
          }
        });
      }
     
    /**
     * 向默认队列发送消息
     */
      public void sendMessage(final String msg) {
        String destination =  jmsQueueTemplate.getDefaultDestination().toString();
        jmsQueueTemplate.send(new MessageCreator() {
          public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage(msg);
          }
        });
     
      }
    
}