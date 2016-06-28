package com.hhm.spring_03_instanceBeanByStaticFactory;

public class CustomerServiceStaticFactory {

	public static Icustomer createCustomerService(){
		return new CustomerImpl();
	}

}
