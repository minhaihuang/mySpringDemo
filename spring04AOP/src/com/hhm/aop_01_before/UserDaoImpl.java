package com.hhm.aop_01_before;
/**
 * IUserDao接口的实现类
 * @author 黄帅哥
 *
 */
public class UserDaoImpl implements IUserDao {

	public void addUser(User user) {
		System.out.println("succeed in adding a user");

	}

}
