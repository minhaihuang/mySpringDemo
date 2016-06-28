package com.hhm.aop_04_after;
/**
 * IUserDao接口的实现类
 * @author 黄帅哥
 *
 */
public class UserDaoImpl implements IUserDao {

	public void addUser(User user) {
		
		System.out.println("succeed in adding a user");
		int i=3/0;//有异常的情况
	}

}
