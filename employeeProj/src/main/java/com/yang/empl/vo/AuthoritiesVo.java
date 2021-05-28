package com.yang.empl.vo;

public class AuthoritiesVo {
	private String authority;
	private String userId;
	public AuthoritiesVo(String authority, String userId) {
		super();
		this.authority = authority;
		this.userId = userId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
