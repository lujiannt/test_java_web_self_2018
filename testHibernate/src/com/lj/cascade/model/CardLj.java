package com.lj.cascade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 测试级联-one2many-单向多的一方
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
	
	//多的一方FetchType默认是eager(会自动读取userLj),设置成lazy就不会自动带出userLj
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	public UserLj getUserlj() {
		return userlj;
	}
	public void setUserlj(UserLj userlj) {
		this.userlj = userlj;
	}
	
}
