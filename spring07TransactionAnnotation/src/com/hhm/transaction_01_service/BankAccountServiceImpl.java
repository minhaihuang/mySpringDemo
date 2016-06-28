package com.hhm.transaction_01_service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhm.transaction_01_dao.IBankAccountDao;
import com.hhm.transaction_01_domain.BankAccount;
@Service("accountService")
//注解加在类前，对所有的方法都适用
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class BankAccountServiceImpl implements IBankAccountService {
	//引入持久层对象
	@Resource(name="bankDao")
	private IBankAccountDao bankDao=null;
	
	public IBankAccountDao getBankDao() {
		return bankDao;
	}


	public void setBankDao(IBankAccountDao bankDao) {
		this.bankDao = bankDao;
	}


	/*
	 * 转账业务。
	 * 参数说明：user1->转账人，user2->收款人，money->金额
	 */
	//注解也可以加在方法前，注意：方法级别的事务覆盖类级别的事务
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public void transferMoney(String user1, String user2, double money) throws Exception{
		//数据有效性判断。
		
		//转账金额小于0
		if(money<0){
			//抛出异常
			throw new RuntimeException("转账金额不能少于0");
		}
		
		//进行转账用户余额的判断
		BankAccount bankAccount1=bankDao.queryBankAccountByName(user1);
		double money1=bankAccount1.getAccountNumber();
		if(money>money1){
			throw new RuntimeException("余额不足");
		}
		
		//转账业务
		//转账人减钱
		bankAccount1.setAccountNumber(money1-money);
		
		//获取收款人，增加钱
		BankAccount bankAccount2=bankDao.queryBankAccountByName(user2);
		bankAccount2.setAccountNumber(bankAccount2.getAccountNumber()+money);
		
		//更新数据库
		bankDao.updateBankAccount(bankAccount1);
		bankDao.updateBankAccount(bankAccount2);
	}

}
