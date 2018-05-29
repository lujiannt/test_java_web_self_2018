package com.lj.ssm.exception;

/**
 * 自定义异常类
 * @author lujian
 * @create 2018年5月29日
 * @version 1.0
 */
public class CustomException extends Exception{
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String messgae;
	
	public CustomException() {
		super();
	}

	public CustomException(String messgae) {
		super();
		this.messgae = messgae;
	}

	public String getMessgae() {
		return messgae;
	}


	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
