package com.hhm.JDBC_02_dbCRUD;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/hhm/JDBC_02_dbCRUD/beans.xml");
		
		IBankAccountDao bankDao=(IBankAccountDao) context.getBean("bankDao");
		
		//BankAccount bankAccount=new BankAccount("hhm", 20000.0);
		
		//bankDao.addBankAccount(bankAccount);成功
		//bankDao.deleteBankAccount(bankAccount);//成功
		//bankDao.updateBankAccount(bankAccount);//成功
		
//		List<BankAccount> bankAccountList=bankDao.queryAllBankAccount();
//		for (BankAccount bankAccount : bankAccountList) {
//			System.out.println(bankAccount);
//		}
		
		BankAccount bankAccount=bankDao.queryBankAccountByName("hhm");
		
		System.out.println(bankAccount.getAccountNumber());
		
	}
}
