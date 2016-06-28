package com.hhm.spring_06_diBean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 测试注入的方式实例化对象：
 * 
 * User类有一个Room的对象room，但是在类中不直接实例化该对象，而是通过配置文件来实例化对象，这就是注入方式
 * @author 黄帅哥
 *
 */
public class User {
	
	private Room room=null;//只声明，但是不实例化，必须有相关的set方法
	private String name=null;
	private Integer age=null;
	
	//外部注入集合，数组，容器，properties等属性
	private List list=null;
	private String[] strs=null;
	
	private Set set=null;
	private Map map=null;
	private Properties props=null;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User(){
		System.out.println("the constructor of User is being used");
	}
	
	public void live(){
		System.out.println("the method live is being used");
		
		//直接调用room的方法，不会报空指针异常，因为在配置文件中已经实例化
		this.room.number();
	}
}
