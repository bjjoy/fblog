package com.cms.mmc.activemq.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.cms.mmc.activemq.service.IServiceConsumer;

//spring配置读取队列中数据
@Service("serviceConsumer")
public class ServiceConsumer implements IServiceConsumer{

    @Autowired
    private JmsTemplate jmsQueueTemplate;
     
    /**
     * 接收消息，spring配置默认destination
     */
    public TextMessage receive(Destination destination) {
        try {
        	TextMessage tm = (TextMessage) jmsQueueTemplate.receive(destination);
            tm.getText();
            return tm;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    /**
     * 接收消息，指定destination队列消息
     */
    public TextMessage receive(String destination) {
        try {
        	TextMessage tm = (TextMessage) jmsQueueTemplate.receive(destination);
            tm.getText();
            return tm;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
