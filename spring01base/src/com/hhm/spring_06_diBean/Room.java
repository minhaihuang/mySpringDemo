package com.hhm.spring_06_diBean;
/**
 * 测试用来测试注入对象方式的Room类
 * @author 黄帅哥
 *
 */
public class Room {
	
	public Room(){
		System.out.println("the constructor of Room is being used");
	}
	
	public void number(){
		System.out.println("the room's number is 3");
	}
}
