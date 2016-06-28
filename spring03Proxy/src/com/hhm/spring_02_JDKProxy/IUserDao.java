package com.hhm.spring_02_JDKProxy;

public interface IUserDao {
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public void queryUser(User user);
}
