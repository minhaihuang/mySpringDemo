package com.hhm.spring_08_componentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_08_componentScan/beans.xml");
		
		ICustomerService customerService=(ICustomerService) context.getBean("customerService");
		customerService.call();
	}
}
