package com.hhm.spring_test01_iocAndDi;
/**
 * 测试注入的方式实例化对象：
 * 
 * Customer类有一个Order的对象order，但是在类中不直接实例化该对象，而是通过配置文件来实例化对象，这就是注入方式
 * @author 黄帅哥
 *
 */
public class Customer {
	
	private Order order=null;//只声明，但是不实例化，必须有相关的set方法
	
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer(){
		System.out.println("the constructor of Customer is being used");
	}
	
	public void live(){
		System.out.println("the method live is being used");
		
		//直接调用room的方法，不会报空指针异常，因为在配置文件中已经实例化
		this.order.number();
	}
}
