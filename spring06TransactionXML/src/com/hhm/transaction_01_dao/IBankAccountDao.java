package com.hhm.transaction_01_dao;

import java.util.List;

import com.hhm.transaction_01_domain.BankAccount;

/**
 * 这是银行的接口类
 * @author 黄帅哥
 *
 */
public interface IBankAccountDao {
	//增
	public void addBankAccount(BankAccount bankAccount);
	//删
	public void deleteBankAccount(BankAccount bankAccount);
	//改
	public void updateBankAccount(BankAccount bankAccount);
	
	//查询全部
	public List<BankAccount> queryAllBankAccount();
	//根据名字查询
	public BankAccount queryBankAccountByName(String userName);
	
}
