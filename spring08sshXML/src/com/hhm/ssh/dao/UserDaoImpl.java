package com.hhm.ssh.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hhm.ssh.domain.User;

public class UserDaoImpl implements IUserDao {
	//利用HibernateTemplate对象来操作数据库
	HibernateTemplate hibernateTemplate = null;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 加入数据库
	 */
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

}
