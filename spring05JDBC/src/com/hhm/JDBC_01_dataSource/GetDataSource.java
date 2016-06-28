package com.hhm.JDBC_01_dataSource;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetDataSource {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/hhm/JDBC_01_dataSource/beans.xml");
		BasicDataSource dataSource = (BasicDataSource) context
				.getBean("datasource");
		System.out.println(dataSource.getConnection());
	}
}
