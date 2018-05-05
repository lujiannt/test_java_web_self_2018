package com.lj.lock.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lj_account")
public class Account {
	private int id;
	private BigDecimal blance;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getBlance() {
		return blance;
	}
	public void setBlance(BigDecimal blance) {
		this.blance = blance;
	}
}
