package com.cms.mmc.activemq;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.mmc.activemq.service.IServiceConsumer;
import com.cms.mmc.activemq.service.IServiceProducer;



//spring配置测试http方式读取，发送数据
@Controller
@RequestMapping("/activemq")
public class TradeController {


    //队列名gzframe.demo
//    @Resource(name="mssQueueDestination")
//    private Destination mssQueueDestination;

    //队列消息生产者
    @Resource(name="serviceProducer")
    private IServiceProducer serviceProducer;
    
    //队列消息消费者
    @Resource(name="serviceConsumer")
    private IServiceConsumer serviceConsumer;
    
    @RequestMapping("/producer")
    @ResponseBody
    public Object producer(){
        System.out.println("------------go producer");
        
        Date now = new Date(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( now ); 
        System.out.println(time);
        return time;
    }
    
    //指定队列发送消息
    @RequestMapping(value="/onsend1",method=RequestMethod.GET)
    @ResponseBody
    public Object producer1(@RequestParam("message") String message) {
        System.out.println("------------send to jms");
        serviceProducer.sendMessage("mssactivemq", message);
        return message + "------------send to jms";
    }
    //默认接收消息队列的内容,spring配置好
    @RequestMapping(value="/onsend2",method=RequestMethod.GET)
    @ResponseBody
    public Object producer2(@RequestParam("message") String message) {
        System.out.println("------------send to jms");
        serviceProducer.sendMessage(message);
        return message + "------------send to jms";
    }
    
    @RequestMapping(value="/receive1",method=RequestMethod.GET)
    @ResponseBody
    public Object queue_receive() throws JMSException {
        
        TextMessage tm = serviceConsumer.receive("activemq.demo");
        System.out.println(tm.getText()+"------------receive1 message");
        return tm.getText()+"------------receive message";
    }
    @RequestMapping(value="/receive2",method=RequestMethod.GET)
    @ResponseBody
    public Object queue_receive2() throws JMSException {
        
        TextMessage tm = serviceConsumer.receive("my-queue2");
        System.out.println(tm.getText()+"------------receive2 message");
        return tm.getText()+"------------receive message";
    }
    
    /*
     * ActiveMQ Manager Test
     */
    @RequestMapping(value="/jms",method=RequestMethod.GET)
    @ResponseBody
    public Object jmsManager() throws IOException {
        System.out.println("------------jms manager");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        
        JMXServiceURL url = new JMXServiceURL("");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();
        MBeanServerConnection connection = connector.getMBeanServerConnection();
        
        return mv.toString();
    }
    
}
