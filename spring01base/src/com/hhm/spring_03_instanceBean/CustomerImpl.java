package com.hhm.spring_03_instanceBean;

public class CustomerImpl implements Icustomer {

	public CustomerImpl(){
		System.out.println("the constructor of CustomerImpl is being used");
	}
	
	public void call() {
		System.out.println("the method call is being used");
	}

}
