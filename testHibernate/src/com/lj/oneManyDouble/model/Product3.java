package com.lj.oneManyDouble.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lj_product3")
public class Product3 {
	private int id;
	private String name;
	private Order3 order;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="orderId")
	public Order3 getOrder() {
		return order;
	}
	public void setOrder(Order3 order) {
		this.order = order;
	}
	
}
