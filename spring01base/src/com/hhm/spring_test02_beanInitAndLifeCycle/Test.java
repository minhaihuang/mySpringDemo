package com.hhm.spring_test02_beanInitAndLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_test02_beanInitAndLifeCycle/beans.xml");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_test02_beanInitAndLifeCycle/beans.xml");
		
		//只有当scope="ptorotype"时，才是按需实例化bean对象
		IOrderService order=(IOrderService) context.getBean("order");
		order.call();
		
		//测试销毁bean时调用的方法，只有当scope="singleton"时才会有效
		context.close();//当关闭容器就会销毁bean
	}
}
