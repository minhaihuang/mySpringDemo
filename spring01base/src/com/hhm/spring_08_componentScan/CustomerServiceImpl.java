package com.hhm.spring_08_componentScan;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("customerService")//业务层
/**
 * @Service("customerService")相当于下面的标签
 * <bean id="customerService" class="com.hhm.spring_08_componentScan.CustomerImpl"/>
 * @author 黄帅哥
 *
 */
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource//注解不能丢
	private ICustomerDao customerDao=null;
	@Resource//注解不能丢
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public CustomerServiceImpl(){
		System.out.println("the constructor of CustomerImpl is being used");
	}
	
	
	public void call() {
		customerDao.add();
		System.out.println("the method call is being used");
	}

}
