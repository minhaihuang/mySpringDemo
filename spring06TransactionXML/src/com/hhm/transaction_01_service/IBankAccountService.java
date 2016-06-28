package com.hhm.transaction_01_service;

public interface IBankAccountService {
	/*
	 * 转账业务。
	 * 参数说明：user1->转账人，user2->收款人，money->金额
	 */
	public void transferMoney(String user1,String user2,double money) throws Exception;
}
