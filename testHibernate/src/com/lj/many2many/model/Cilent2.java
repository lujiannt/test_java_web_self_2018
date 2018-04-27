package com.lj.many2many.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试多对多-xml
 * 客户 和 健身课
 * @author lujian
 * @create 2018年4月27日
 * @version 1.0
 */
public class Cilent2 {
	private int id;
	private String name;
	private Set<FitCourse> courses = new HashSet<FitCourse>();
	
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
	public Set<FitCourse> getCourses() {
		return courses;
	}
	public void setCourses(Set<FitCourse> courses) {
		this.courses = courses;
	}
}
