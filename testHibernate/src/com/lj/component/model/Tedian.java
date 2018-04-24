package com.lj.component.model;

import javax.persistence.Column;

public class Tedian {
	private int weight;
	private String hobby;
	
	@Column(name="weight")
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
