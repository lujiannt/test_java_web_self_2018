package com.lj.oneManyDouble.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lj_order3")
public class Order3 {
	private int id;
	private String name;
	private Set<Product3> products = new HashSet<Product3>();
	
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
	
	//双向关联时在one2many的一方设置mappedby,由多的一方主导外键关系
	//如果不设置 (mappedBy="order")就会生成一张中间表
	//mappedBy指的是对方product中的order属性
	@OneToMany(mappedBy="order")
	public Set<Product3> getProducts() {
		return products;
	}
	public void setProducts(Set<Product3> products) {
		this.products = products;
	}
	
	
}
