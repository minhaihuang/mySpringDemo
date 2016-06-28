package com.hhm.quartz.test01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试任务调度器
 * @author 黄帅哥
 *
 */
public class Test {
	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("com/hhm/quartz/test01/beans.xml");
	}
}
