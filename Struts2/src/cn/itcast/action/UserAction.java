package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//使用模型驱动
public class UserAction extends ActionSupport{

	private String userName;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String login() throws Exception {

		System.out.println("login method.....");

		return null;
	}

	public String regist() throws Exception {

		System.out.println("regist method.....");

		return null;
	}

	
}
