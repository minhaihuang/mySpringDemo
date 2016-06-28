package com.hhm.spring_01_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试IOC（Inversion of Control）控制反转，即不是自己创建对象，而是由外部创建对象，把控制权交出。
 * @author 黄帅哥
 *
 */
public class TestIOC {

	public static void main(String[] args) {
		//以前的调用User类的方法的方式：要创建一个user对象，再有user对象调用。
//		User user=new User();
//		user.live();
		
		//现在的调用User类的方法的方式
		
		//创建一个读取配置文件的对象
		ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_01_ioc/beans.xml");
		//通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		User user=context.getBean(User.class);
		user.live();
		
	}
}
