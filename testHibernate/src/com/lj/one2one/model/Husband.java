package com.lj.one2one.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lj_husband")
public class Husband {
	private int id;
	private String husName;
	private Wife wife;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHusName() {
		return husName;
	}
	public void setHusName(String husName) {
		this.husName = husName;
	}
	@OneToOne
	@JoinColumn(name="wifeId")
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
