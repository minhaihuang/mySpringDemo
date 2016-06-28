package com.hhm.spring_02_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		//以前的调用User类的方法的方式：要创建一个user对象，再有user对象调用。
//		User user=new User();
//		user.live();
		
		//现在的调用User类的方法的方式
		
		//创建一个读取配置文件的对象
		//第一种获取applicationContext对象的方法
		//ApplicationContext context=new ClassPathXmlApplicationContext("com/hhm/spring_02_di/beans.xml");
		
		//第二种获取applicationContext对象的方法
		ApplicationContext context=new FileSystemXmlApplicationContext("G:\\workspace\\kuangjia\\spring01base\\src\\com\\hhm\\spring_02_di\\beans.xml");
		
		//通过文件内部获取user对象，在文件内部对象会其实例化，实际上是通过反射技术实例化
		User user=context.getBean(User.class);
		user.live();
		
	}
}
