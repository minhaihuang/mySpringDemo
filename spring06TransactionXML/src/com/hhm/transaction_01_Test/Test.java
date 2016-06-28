package com.hhm.transaction_01_Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hhm.transaction_01_dao.IBankAccountDao;
import com.hhm.transaction_01_domain.BankAccount;
import com.hhm.transaction_01_service.IBankAccountService;


public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		
		IBankAccountService accountService=(IBankAccountService) context.getBean("accountService");
	
		accountService.transferMoney("hhm", "hhm1", 1000.0);
	}
}
