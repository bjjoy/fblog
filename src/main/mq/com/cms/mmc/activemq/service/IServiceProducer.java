package com.cms.mmc.activemq.service;

public interface IServiceProducer {

	/**
     * 向指定队列发送消息
     */
    public void sendMessage(String destination, final String msg);
    /**
     * 向默认队列发送消息
     */
    public void sendMessage(final String msg);
}
