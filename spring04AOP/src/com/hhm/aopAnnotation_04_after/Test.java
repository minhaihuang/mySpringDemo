package com.hhm.aopAnnotation_04_after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这是测试用注解实现AOP配置的测试类
 * 测试最终通知
 * @author 黄帅哥
 * 
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/hhm/aopAnnotation_04_after/beans.xml");
		
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		
		userDao.addUser(new User("hhm",18));
	}
}
