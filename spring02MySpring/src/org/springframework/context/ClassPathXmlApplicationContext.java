package org.springframework.context;

import java.io.InputStream;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
	private Map<String,Object> beanMap=null;
	
	public Object getBean(String beanName) {
		
		return beanMap.get(beanName);
	}
	
	/**
	 * 空构造
	 * @param filePath
	 */
	public ClassPathXmlApplicationContext(){
		
	}
	
	public ClassPathXmlApplicationContext(String filePath){
		System.out.println(filePath);
		InputStream in=this.getClass().getClassLoader().getResourceAsStream(filePath);
	
		this.beanMap=(Map<String, Object>) Utils.readXmlFile(in);
		
	}

}
