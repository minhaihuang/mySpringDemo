package com.hhm.spring_test01_iocAndDi;
/**
 * 测试用来测试注入对象方式的Room类
 * @author 黄帅哥
 *
 */
public class Order {
	
	public Order(){
		System.out.println("the constructor of Order is being used");
	}
	
	public void number(){
		System.out.println("the order's number is 3");
	}
}
