package com.lj.component.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lj_person")
public class Person2 {
	private int id;
	private String name;
	private Tedian tedian;
	
	@Id
	@GeneratedValue
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
	@Embedded
	public Tedian getTedian() {
		return tedian;
	}
	public void setTedian(Tedian tedian) {
		this.tedian = tedian;
	}
	
}
