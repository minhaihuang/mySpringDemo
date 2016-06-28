package com.hhm.spring_test02_beanInitAndLifeCycle;

public class OrderServiceImpl implements IOrderService {

	//方式二专用
//	public IOrderService createOrderService(){
//		return new OrderServiceImpl();
//	}
	
	//方式三专用
	public static IOrderService createOrderService(){
		return new OrderServiceImpl();
	}
	
	public OrderServiceImpl(){
		System.out.println("the constructor of OrderServiceImpl is being used");
	}
	
	public void call() {
		System.out.println("the method call is being used");
	}

	public void init(){
		System.out.println("the method init is being used");
	}
	
	public void destroy(){
		System.out.println("the method destroy is being used");
	}
}
