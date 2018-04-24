package com.lj.one2one.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lj_wife")
public class Wife {
	private int id;
	private String name;
	private Husband husband;
	
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
	//one2one双向设置时，需要加上mappedBy，其值指的是对方的属性,表示这个关系由对方主导
	//xml中使用 property-ref设置，并且xml中，该方是one-to-one(单向时是many-to-one)
	@OneToOne(mappedBy="wife")
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	
	
}
