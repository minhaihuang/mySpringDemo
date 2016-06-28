package com.hhm.spring_02_JDKProxy;

public class UserDaoImpl implements IUserDao{

	public void addUser(User user) {
		System.out.println("the addUser method is being used");
		
	}

	public void deleteUser(User user) {
		System.out.println("the deleteUser method is being used");
	}

	public void updateUser(User user) {
		System.out.println("the updateUser method is being used");
		
	}

	public void queryUser(User user) {
		System.out.println("the queryUser method is being used");
		
	}

}
