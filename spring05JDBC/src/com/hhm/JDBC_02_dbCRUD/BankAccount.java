package com.hhm.JDBC_02_dbCRUD;

public class BankAccount {
	private String userName = null;
	private Double accountNumber = null;
	
	

	public BankAccount() {
		super();
	}

	public BankAccount(String userName, Double accountNumber) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Double accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return (this.getUserName()+"-->"+this.getAccountNumber());
	}
}
