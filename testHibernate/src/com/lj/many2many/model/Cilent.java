package com.lj.many2many.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

/**
 * 测试多对多-annotation
 * 客户 和 健身课
 * @author lujian
 * @create 2018年4月27日
 * @version 1.0
 */
@Entity
@Table(name="lj_client")
public class Cilent {
	private int id;
	private String name;
	private Set<FitCourse> courses = new HashSet<FitCourse>();
	
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
	@ManyToMany
	@JoinTable(name="lj_cc",
		joinColumns={@JoinColumn(name="clientId")},
		inverseJoinColumns={@JoinColumn(name="courseId")}
		)
	public Set<FitCourse> getCourses() {
		return courses;
	}
	public void setCourses(Set<FitCourse> courses) {
		this.courses = courses;
	}
}
