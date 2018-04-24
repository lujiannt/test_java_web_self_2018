package com.lj.compositeId.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="lj_teacher")
public class Teacher {
	private TeacherPk teacherPk;
	private Date birth;
	private Zhicheng zc;
	
	@EmbeddedId
	public TeacherPk getTeacherPk() {
		return teacherPk;
	}
	public void setTeacherPk(TeacherPk teacherPk) {
		this.teacherPk = teacherPk;
	}
	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Enumerated(EnumType.STRING)
	public Zhicheng getZc() {
		return zc;
	}
	public void setZc(Zhicheng zc) {
		this.zc = zc;
	}
	
	
}
