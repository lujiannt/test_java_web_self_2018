package com.lj.query.model;

/**
 * 卡 封装类
 * @author lujian
 * @create 2018年5月2日
 * @version 1.0
 */
public class CardInfoDto {
	private int id;
	private String cardName;
	private String employeeName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "CardInfoDto [id=" + id + ", cardName=" + cardName + ", employeeName=" + employeeName + "]";
	}
	
}
