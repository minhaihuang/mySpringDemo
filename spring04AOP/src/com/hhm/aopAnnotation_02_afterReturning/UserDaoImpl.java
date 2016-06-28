package com.hhm.aopAnnotation_02_afterReturning;

public class UserDaoImpl implements IUserDao {

	public void addUser(User user) {
		System.out.println("succeed in adding a user");

	}

}
