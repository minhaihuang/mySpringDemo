package com.hhm.ssh.domain;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;
	private String userName;

	public User() {
		super();
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
