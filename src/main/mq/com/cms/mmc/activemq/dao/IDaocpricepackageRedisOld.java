package com.cms.mmc.activemq.dao;
import java.util.Map;
/**
 * Dao接口
 * @author maze
 * @date
 */
public interface IDaocpricepackageRedisOld{

	/**
	 * 插入操作
	 * @param id 对象的id
	 * @param value 对象的json内容
	 */
	public void set(String id,String value);
    
	/**
	 * 删除操作
	 * @param id 对象的id
	 */
    public void delete(String id);
    
    /**
     * 获取所有的对象根据命名空间
     * @return
     */
    public Map<String, String> getAll();
    
    /**
     * 获取对象
     * @param id 对象的id
     * @return
     */
    public String get(String id);
	

}