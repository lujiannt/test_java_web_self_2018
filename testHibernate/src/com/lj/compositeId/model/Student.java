package com.lj.compositeId.model;

import java.util.Date;

public class Student {
	private StudentPk studentPk;
	private Date birth;
	private Zhicheng zc;
	private boolean isgood;
	
	public StudentPk getStudentPk() {
		return studentPk;
	}
	public void setStudentPk(StudentPk studentPk) {
		this.studentPk = studentPk;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Zhicheng getZc() {
		return zc;
	}
	public void setZc(Zhicheng zc) {
		this.zc = zc;
	}
	public boolean isIsgood() {
		return isgood;
	}
	public void setIsgood(boolean isgood) {
		this.isgood = isgood;
	}
	
}
