package com.hhm.spring_06_diBean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试DI,，外部注入的方式实例化对象
 * 
 * 注意：若beans.xml中有多个bean标签，会依照在文件中的顺序先后实例化对象
 * 例如：Room的bean标签比User的前，则会先实例化Room
 * @author 黄帅哥
 *
 */
public class TestDI {

	public static void main(String[] args) {
		
		
		//创建一个读取配置文件的对象
		ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_06_diBean/beans.xml");
		
		//通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		User user=context.getBean(User.class);
		user.live();
		
		System.out.println(user.getName());
		System.out.println(user.getAge());
		
		System.out.println("########ListElement#########");
		List list=user.getList();
		for (Object object : list) {
			System.out.println(object);
		}
		
		
		System.out.println("#####arrayElement######");
		String[] strs=user.getStrs();
		for (String string : strs) {
			System.out.println(string);
		}
		
		System.out.println("#######setElement########");
		Set set=user.getSet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("#######mapElement#########");
		Map map=user.getMap();
		Set set2=map.keySet();
		Iterator it2=set2.iterator();
		while(it2.hasNext()){
			String key=(String) it2.next();
			System.out.println(key);
			System.out.println(map.get(key));
		}
		
		System.out.println("#######propertiesElement####");
		Properties props=user.getProps();
		Set set3=props.keySet();
		Iterator it3=set3.iterator();
		while(it3.hasNext()){
			String key=(String) it3.next();
			System.out.println(key);
			System.out.println(props.get(key));
		}
		
	}
}
