package com.lj.oneManyDouble.model;

import java.util.HashSet;
import java.util.Set;

/**
 * onetomany双向-xml
 * @author lujian
 * @create 2018年4月27日
 * @version 1.0
 */
public class Order4 {
	private int id;
	private String name;
	private Set<Product4> products = new HashSet<Product4>();
	
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
	public Set<Product4> getProducts() {
		return products;
	}
	public void setProducts(Set<Product4> products) {
		this.products = products;
	}
		
	
}
