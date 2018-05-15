package com.lj.model;

import java.util.Date;

public class User {
	private int id;
	private String userName;
	private int age;
	private Date creatTime;
	
	public User() {
		super();
	}
	
	public User(int id, String userName, int age, Date creatTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.creatTime = creatTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
}
