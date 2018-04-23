package com.lj.test.hello;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class HelloAction extends ActionSupport{
	private Date birth;
	private String name;
	//0:中文 1：英文
	private int isUs;
	//http://localhost:8080/Struts2/hello.action?name=111&request_locale=en_US&isUs=0
	//判断了validate  动态国际化    还有拦截器
	public String openToHello() {
		if(isUs == 0) {
			System.out.println(getText("index.title", new String[]{"啊","那不是爱情"}));
		}else {
			System.out.println(getText("index.title", new String[]{"aa","bb"}));
		}
		//System.out.println(getText("index.title"));
		return SUCCESS;
	}

	public String openToIndex() {
		return SUCCESS;
	}
	
	
	
	
	
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 校验(该action中所有方法都会校验)
	 * @author lujian
	 * @create 2017年3月27日
	 */
	@Override
	public void validate() {
		System.out.println("all validate");
		if(name == null) {
			this.addFieldError("birthErr", "all name is null");
		}
	}
	
	/**
	 * 单独校验某方法
	 * @author lujian
	 * @create 2017年3月27日
	 */
	public void validateOpenToHello() {
		System.out.println(" validate");
		if(name == null) {
			this.addFieldError("birthErr", "single name is null");
		}
	}

	public int getIsUs() {
		return isUs;
	}

	public void setIsUs(int isUs) {
		this.isUs = isUs;
	}
	
	
}
