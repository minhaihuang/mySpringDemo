package com.hhm.spring_04_bean_initTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean的初始化时间，以及bean的作用域（初始化方式）。
 * 
 * @author 黄帅哥
 * 
 */
public class Test {

	public static void main(String[] args) {

		/*
		 * 当在bean标签中增加属性scope="singleton"，它是默认的，不设置也有同样效果，
		 * 每一个ApplicationContext只能初始化一次bean对象
		 */
		// 创建一个读取配置文件的对象，初始化一次
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "com/hhm/spring_04_bean_initTime/beans.xml");
		// // 创建另外一个读取配置文件的对象，再次初始化，因为是不同的容器
		// ApplicationContext context2 = new ClassPathXmlApplicationContext(
		// "com/hhm/spring_04_bean_initTime/beans.xml");

		// 通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		// User user=(User) context.getBean("user");
		// User user2=(User)context.getBean("user");
		// User user3=(User)context2.getBean("user");
		//
		// System.out.println(user==user2);//true，证明同一个容器只初始化一次对象
		// System.out.println(user==user3);//false
		// user.live();

		/*
		 * 默认情况下在容器启动时初始化bean， 如指定Bean节点属性lazy-init=“true”则只有第一次获取bean时才初始化bean。
		 * 如： <bean id="xxx" class="com.rupeng.OrderServiceBean"
		 * lazy-init="true"/>
		 * 
		 * 如需对所有bean延迟初始化，可在根节点beans设置default-lazy-init=“true“， 如：<beans
		 * default-lazy-init="true“ ...>
		 */

		/*
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "com/hhm/spring_04_bean_initTime/beans.xml"); //
		 * 创建另外一个读取配置文件的对象，再次初始化，因为是不同的容器 //上面的代码还没有使用，所以不会初始化，当调用下面的代码后，开始初始化，且
		 * //每一个容器只初始化一次 User user=(User) context.getBean("user"); user.live();
		 */

		/*
		 * 当设置scope="prototype"时，每一个容器都可以根据需要初始化多次对象
		 */
		 ApplicationContext context = new ClassPathXmlApplicationContext(
		 "com/hhm/spring_04_bean_initTime/beans.xml");
	
		 
		// 通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		 User user=(User) context.getBean("user");
		 User user2=(User)context.getBean("user");
		
		 System.out.println(user==user2);//false，证明了同一个容器两次初始化的对象不同
	
		 user.live();
	}
}
