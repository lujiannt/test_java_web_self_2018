package com.lj.mybatis.model;

import java.math.BigDecimal;

public class OrderProduct {
	protected int id;
	protected int orderId;
	protected String productName;
	protected BigDecimal price;
	protected Integer number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", orderId=" + orderId + ", productName=" + productName + ", price=" + price
				+ ", number=" + number + "]";
	}
	
	
}
