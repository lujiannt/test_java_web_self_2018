package com.lj.one2many.model;

import java.util.HashSet;
import java.util.Set;

public class Order2 {
	private int id;
	private String name;
	private Set<Product2> products = new HashSet<Product2>();
	
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
	public Set<Product2> getProducts() {
		return products;
	}
	public void setProducts(Set<Product2> products) {
		this.products = products;
	}
	
	
}
