package com.yang.empl.vo;

public class UserInfoVo {
	private String userId;
	private String userPassword;
	private int enabled;
	private int changePassword;
	public UserInfoVo(String userId, String userPassword, int enabled, int changePassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.enabled = enabled;
		this.changePassword = changePassword;
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
	public int getChangePassword() {
		return changePassword;
	}
	public void setChangePassword(int changePassword) {
		this.changePassword = changePassword;
	}
}
