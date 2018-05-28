package com.lj.ssm.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class User {
	/*状态常量 0:已删除 1：正常*/
	public static final short STATUS_DELETE = 0;
	public static final short STATUS_NORMAL = 1;
	
	private int id;
	private short status;
	@Size(max=5,message="{user.userName.length.error}")
	private String userName;
	private Integer age;
	private Date createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public static short getStatusDelete() {
		return STATUS_DELETE;
	}
	public static short getStatusNormal() {
		return STATUS_NORMAL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
