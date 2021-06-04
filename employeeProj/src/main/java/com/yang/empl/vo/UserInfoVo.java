package com.yang.empl.vo;

public class UserInfoVo {
	private String userId;
	private String userPassword;
	private int enabled;
	public UserInfoVo(String userId, String userPassword, int enabled) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.enabled = enabled;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
}
