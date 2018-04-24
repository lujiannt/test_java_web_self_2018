package com.lj.compositeId.model;

import java.io.Serializable;

//实现序列化，并且重写equals和hashcode方法
public class TeacherPk implements Serializable{
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TeacherPk) {
			TeacherPk tpk = (TeacherPk)obj;	
			if(this.name.equals(tpk.getName()) && this.id == tpk.getId()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	
}
