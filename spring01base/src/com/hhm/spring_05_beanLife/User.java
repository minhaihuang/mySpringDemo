package com.hhm.spring_05_beanLife;
/**
 * 测试IOC（Inversion of Control）控制反转，即不是自己创建对象，而是由外部创建对象，把控制权交出。
 * @author 黄帅哥
 *
 */
public class User {
	
	public User(){
		System.out.println("the constructor of User is being used");
	}
	
	public void live(){
		System.out.println("the method live is being used");
	}
	
	public void init(){
		System.out.println("the method init is being used");
	}
	
	public void destroy(){
		System.out.println("the method destroy is being used");
	}
}
