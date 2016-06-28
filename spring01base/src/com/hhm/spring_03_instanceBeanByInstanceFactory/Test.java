package com.hhm.spring_03_instanceBeanByInstanceFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_03_instanceBeanByInstanceFactory/beans.xml");
		
		Icustomer customer=(Icustomer) context.getBean("customer");
		customer.call();
	}
}
