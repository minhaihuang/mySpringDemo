package com.hhm.spring_05_beanLife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean的生命周期，测试初始化方法以及销毁方法的调用过程
 * @author 黄帅哥
 * 
 */
public class Test {

	public static void main(String[] args) {

		
//		 ApplicationContext context = new ClassPathXmlApplicationContext(
//		 "com/hhm/spring_05_beanLife/beans.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				 "com/hhm/spring_05_beanLife/beans.xml");
	
		 
		 //通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		 User user=(User) context.getBean("user");
		 
		 context.close();//关闭容器，则会销毁bean对象，调用destroy方法
	
	}
}
