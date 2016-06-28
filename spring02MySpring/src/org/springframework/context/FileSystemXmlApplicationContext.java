package org.springframework.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class FileSystemXmlApplicationContext implements ApplicationContext{
private Map<String,Object> beanMap=null;
	
	public Object getBean(String beanName) {
		
		return beanMap.get(beanName);
	}
	
	/**
	 * 空构造
	 * @param filePath
	 */
	public FileSystemXmlApplicationContext() {
		
	}
	
	public FileSystemXmlApplicationContext(String filePath){
		File file=new File(filePath);
		InputStream in;
		try {
			in = new FileInputStream(file);
			this.beanMap=(Map<String, Object>) Utils.readXmlFile(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
