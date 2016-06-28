package com.hhm.aop_05_Proceeding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里是测试AOP编程的代码，根之前的普通获取bean的方法一模一样，用法也一样
 * 
 * @author 黄帅哥
 * 
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/hhm/aop_05_Proceeding/beans.xml");
		
		//获取bean
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		
		userDao.addUser(new User("hhm",18));
	}
}
