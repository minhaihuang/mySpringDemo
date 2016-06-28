package com.hhm.spring_02_JDKProxy;
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
		//使用代理
		ObjectJDKProxy objectJDKProxy=new ObjectJDKProxy(new UserDaoImpl());
		//创建一个被代理对象(目标对象)
		IUserDao userDao=(IUserDao) objectJDKProxy.createRealObjectInstance();
		userDao.addUser(user);
	}
	
}
