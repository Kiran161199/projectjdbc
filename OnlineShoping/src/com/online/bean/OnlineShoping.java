package com.online.bean;

public class OnlineShoping {
	private String userName;
	private String password;
	private long number;
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public long getNumber() {
		return number;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public OnlineShoping(String userName, String password, long number) {
		super();
		this.userName = userName;
		this.password = password;
		this.number = number;
	}
	@Override
	public String toString() {
		return "OnlineShoping [userName=" + userName + ", password=" + password + ", number=" + number + "]";
	}
	
	
}
