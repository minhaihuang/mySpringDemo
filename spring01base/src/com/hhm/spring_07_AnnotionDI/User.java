package com.hhm.spring_07_AnnotionDI;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 测试注入的方式实例化对象：
 * 
 * User类有一个Room的对象room，但是在类中不直接实例化该对象，而是通过配置文件来实例化对象，这就是注入方式
 * @author 黄帅哥
 *
 */
public class User {
	
	//@Autowired:用此注解，则会自动在beans.xml文件中寻找是否有Room的bean标签，若有，则创建对象，没有，则会报错
	
	//@Qualifier(value="room")：用此注解，则会在beans.xml中找到名字为room的bean，若没有，则会报错
	
	//通常两个注解结合起来使用，若没有@Autowired，则会报错。
	
	//@Resource：若没有标明名字，则按照默认的名字去找，若找不到，则按照类型去找
	
	//@Autowired @Qualifier(value="room")
	//@Resource 没有声明名字
	@Resource(name="room") //声明了名字，按照名字去找，找不到，则报错
	private Room room=null;
	
	@Autowired @Qualifier(value="room")
	public void setRoom(Room room) {
		this.room = room;
	}

	public User(){
		System.out.println("the constructor of User is being used");
	}
	
	public void live(){
		System.out.println("the method live is being used");
		
		//直接调用room的方法，不会报空指针异常，因为在配置文件中已经实例化
		this.room.number();
	}
	
	//利用此注解指定默认的初始化方法
	@PostConstruct
	public void init(){
		System.out.println("the method init is being used");
	}
	
	//利用此注解指定默认的销毁方法
	@PreDestroy
	public void destroy(){
		System.out.println("the method destroy is being used");
	}
}
