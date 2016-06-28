package com.hhm.ssh.service;

import com.hhm.ssh.dao.IUserDao;
import com.hhm.ssh.domain.User;

public class UserService {
	private IUserDao userDao=null;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addUser(User user){
		this.getUserDao().addUser(user);
	}
	
}
