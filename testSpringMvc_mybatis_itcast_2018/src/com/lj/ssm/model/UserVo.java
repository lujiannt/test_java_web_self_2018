package com.lj.ssm.model;

import java.util.List;

public class UserVo{
	private User user;
	private UserCustom userCustom;
	private List<Integer> ids;
	private List<UserCustom> userList;
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	public List<UserCustom> getUserList() {
		return userList;
	}
	public void setUserList(List<UserCustom> userList) {
		this.userList = userList;
	}
}
