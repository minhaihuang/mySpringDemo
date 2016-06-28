package com.hhm.spring_01_staticProxy;

public class UserStaticProxyImpl implements IUserDao{
	private IUserDao userDao=new UserDaoImpl();
	
	public void addUser(User user) {
		System.out.println("checkSecurity ");
		userDao.addUser(user);
		
	}

	public void deleteUser(User user) {
		System.out.println("checkSecurity ");
		userDao.deleteUser(user);
	}

	public void updateUser(User user) {
		System.out.println("checkSecurity ");
		userDao.updateUser(user);
		
	}

	public void queryUser(User user) {
		System.out.println("checkSecurity ");
		userDao.queryUser(user);
		
	}
}
