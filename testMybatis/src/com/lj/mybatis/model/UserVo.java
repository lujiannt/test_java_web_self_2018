package com.lj.mybatis.model;

/**
 * 包装类，对应复杂多表查询
 * @author lujian
 * @create 2018年5月9日
 * @version 1.0
 */
public class UserVo extends User{
	protected User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
