package com.hhm.ssh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhm.ssh.dao.IUserDao;
import com.hhm.ssh.domain.User;
@Service("userService")
@Transactional(isolation=Isolation.DEFAULT,readOnly=true,propagation=Propagation.REQUIRED)
public class UserServiceImpl implements IUserService{
	private IUserDao userDao=null;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional(isolation=Isolation.DEFAULT,readOnly=false,propagation=Propagation.REQUIRED)
	public void addUser(User user){
		this.getUserDao().addUser(user);
	}
	
}
