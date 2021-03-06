package com.hhm.spring_02_di;
/**
 * 测试注入的方式实例化对象：
 * 
 * User类有一个Room的对象room，但是在类中不直接实例化该对象，而是通过配置文件来实例化对象，这就是注入方式
 * @author 黄帅哥
 *
 */
public class User {
	
	private Room room=null;//只声明，但是不实例化，必须有相关的set方法
	
	
	
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
}
