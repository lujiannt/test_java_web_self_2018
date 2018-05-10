package com.lj.mybatis.model;

import java.util.Date;

public class Order {
	protected int id;
	protected int userId;
	protected String orderNo;
	protected Date createTime;
	
	/*user*/
	protected User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", createTime=" + createTime
				+ ", user=" + user + "]";
	}
}
