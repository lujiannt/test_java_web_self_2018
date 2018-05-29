package com.lj.ssm.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lj.ssm.validate.group.ValidateGroup1;
import com.lj.ssm.validate.group.ValidateGroup2;

public class User {
	/*状态常量 0:已删除 1：正常*/
	public static final short STATUS_DELETE = 0;
	public static final short STATUS_NORMAL = 1;
	
	private int id;
	private short status;
	@Size(max=5,message="{user.userName.length.error}",groups={ValidateGroup1.class})
	private String userName;
	@NotNull(message="{user.age.isNull.error}",groups={ValidateGroup2.class})
	private Integer age;
	private String pic;
	private Date createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public static short getStatusDelete() {
		return STATUS_DELETE;
	}
	public static short getStatusNormal() {
		return STATUS_NORMAL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
