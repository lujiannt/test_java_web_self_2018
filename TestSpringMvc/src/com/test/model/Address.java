package com.test.model;


/**
 * @author lujian
 * @create 2017年4月27日
 * @version 1.0
 */
public class Address{
	private int addressId;
	private String address;
	private String postCode;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address
				+ ", postCode=" + postCode + "]";
	}
	
}
