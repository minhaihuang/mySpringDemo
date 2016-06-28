package com.hhm.aopAnnotation_04_after;

public class UserDaoImpl implements IUserDao {

	public void addUser(User user) {
		System.out.println("succeed in adding a user");
		//int i=3/0;//有异常的情况
	}

}
