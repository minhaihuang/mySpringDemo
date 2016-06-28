package com.hhm.ssh.view;

import com.hhm.ssh.domain.User;
import com.hhm.ssh.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	//业务层对象
	private UserService userService=null;
	private User user = null;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {

		return user;
	}
	
	public String addUser(User user){
		//调用业务层的方法加入数据库
		this.getUserService().addUser(user);
		return "success";
	}

}
