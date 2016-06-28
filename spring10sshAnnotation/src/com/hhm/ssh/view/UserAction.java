package com.hhm.ssh.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hhm.ssh.domain.User;
import com.hhm.ssh.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//业务层对象
	@Resource(name="userService")
	private IUserService userService=null;
	//用了ModelDriven来填充数据时，一定要用new来创建对象，否则无法自动填充数据
	private User user = new User();

	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
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
	
	public String addUser(){
		System.out.println(user.getUserName());
		//调用业务层的方法加入数据库
		this.getUserService().addUser(user);
		return "success";
	}

}
