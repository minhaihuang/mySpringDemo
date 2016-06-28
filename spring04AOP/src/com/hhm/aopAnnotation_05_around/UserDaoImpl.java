package com.hhm.aopAnnotation_05_around;

public class UserDaoImpl implements IUserDao {

	public void addUser(User user) {
		System.out.println("succeed in adding a user");
		int i=3/0;//有异常的情况
	}

}
