package com.hhm.aop_02_afterAndReturnValue;
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
