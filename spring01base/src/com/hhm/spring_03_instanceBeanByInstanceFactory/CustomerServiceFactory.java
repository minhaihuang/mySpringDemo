package com.hhm.spring_03_instanceBeanByInstanceFactory;

public class CustomerServiceFactory {

	//不能是静态的方法
	public Icustomer createCustomerService(){
		return new CustomerImpl();
	}

}
