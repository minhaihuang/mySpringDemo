package com.hhm.spring_08_componentScan;

import org.springframework.stereotype.Repository;

@Repository("customerDao")//持久层
/**
 * @Repository("customerDao")相当于下面的标签
 * <bean id="customerDao" class="com.hhm.spring_08_componentScan.CustomerDaoImpl"/>
 * @author 黄帅哥
 *
 */
public class CustomerDaoImpl implements ICustomerDao {

	public void add() {
		System.out.println("hahaha add method");
	}

}
