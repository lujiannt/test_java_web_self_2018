package com.lj.test.user;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private String username;
	private User user;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String openToUserIndex() {
		System.out.println(1);
		return SUCCESS;
	}
	
	public String va() {
		System.out.println(username);
		return SUCCESS;
	}
	
	
	
	

}