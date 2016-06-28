package com.hhm.spring_01_staticProxy;
/**
 * 测试静态代理模式
 * @author 黄帅哥
 *
 */
public class Test {
	public static void main(String[] args) {
		//通常的调用
//		User user=new User("hhm", 18);
//		IUserDao userDao=new UserDaoImpl();
//		userDao.addUser(user);
		
		//代理模式的调用
		User user=new User("hhm",18);
		IUserDao userDao=new UserStaticProxyImpl();
		userDao.addUser(user);
	}
	
}
