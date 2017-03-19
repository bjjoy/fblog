package com.cms.mmc.activemq;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.mmc.activemq.dao.IDaocpricepackageRedisOld;
import com.cms.mmc.activemq.service.IServiceProducer;

//spring配置监听队列中的消息
@Component
@EnableJms
public class QueueMessageListener{

	 @Resource(name="serviceProducer")
	 private IServiceProducer serviceProducer;
	 
    //当收到消息后，自动调用该方法,spring配置默认监听器，负责接收消息
	@JmsListener(containerFactory="jmsListenerContainerFactory",destination = "mssactivemq")
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
        	System.out.println(tm.getText());
        	if(tm!=null && tm.getText()!=null){
	            JSONObject msg = JSON.parseObject(tm.getText().toString());
	            if(msg.get("commKey").equals("send")){
	            	this.getSendMsg(msg);
	            }else if(msg.get("commKey").equals("back")){
	            	this.getBackMsg(msg);
	            }
	            
        	}
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    //获取消息后返回给客户端是否成功
    private void backToClientMsg(String destination, final String msg){
    	serviceProducer.sendMessage(destination, msg);
    }
    
    private void getSendMsg(JSONObject msg){
    	JSONObject jsonObject = new JSONObject();
        jsonObject.put("commKey", "back");
		jsonObject.put("id", msg.get("id").toString());
		jsonObject.put("pId", msg.get("pId").toString());
		jsonObject.put("key", msg.get("id").toString()+"_"+msg.get("pId").toString());
		jsonObject.put("code", "equipment");
    	try {
    		//
			//写入数据库操作没，解析items对象
			//
    		jsonObject.put("msg", "成功");
    		jsonObject.put("errCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "失败");
			jsonObject.put("errCode", 1);
		}
    	this.backToClientMsg(msg.get("pId").toString(), jsonObject.toJSONString());
    }
    
    private void getBackMsg(JSONObject msg){
    	try {
			String errCode = msg.get("errCode").toString();
			if(errCode.equals("0")){
				 String oldId = msg.get("id").toString();
//				 hashRepository.
				//删除redis里边oldId的数据
			}else if(errCode.equals("0")){
				 String oldId = msg.get("id").toString();
				 //从oldId表拿出数据放到new表
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("commKey", "send");
//		jsonObject.put("id", "记录唯一标识");
//		jsonObject.put("pId", "商家ID");
//		jsonObject.put("commKey", "send");
		jsonObject.put("id", "1111");
		jsonObject.put("partnerId", "asdf");
		JSONObject jsonObject2 = new JSONObject();
//		jsonObject.put("commKey", "send");
//		jsonObject.put("id", "记录唯一标识");
//		jsonObject.put("pId", "商家ID");
//		jsonObject.put("commKey", "send");
		jsonObject2.put("id", "1111");
		jsonObject2.put("partnerId", "asdf");
		JSONArray ja = new JSONArray();
		ja.add(jsonObject);
		ja.add(jsonObject2);
//		List<Map<String,Object>> m = new ArrayList<Map<String,Object>>();
		List<Map> m= JSON.parseArray(ja.toJSONString(), Map.class);
		System.out.println(m);
		try{
			JSON.parseObject("123");
		}catch(Exception e){
			System.out.println("1111111");
		}
//		PoJoPlayerRefundCoins p = JSON.parseObject(jsonObject.toJSONString(), PoJoPlayerRefundCoins.class);
		System.out.println(JSON.parseObject(jsonObject.toJSONString()));
	}

//	public void onMessage(Message arg0) {
//		// TODO Auto-generated method stub
//		
//	}
}