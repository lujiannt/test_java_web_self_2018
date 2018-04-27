package com.lj.cascade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 测试级联
 * @author lujian
 * @create 2018年4月27日
 * @version 1.0
 */
@Entity
@Table(name="lj_cardLj")
public class CardLj {
	private int id;
	private String name;
	private UserLj userlj;
	
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
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="userId")
	public UserLj getUserlj() {
		return userlj;
	}
	public void setUserlj(UserLj userlj) {
		this.userlj = userlj;
	}
	
}
