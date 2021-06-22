package com.yang.empl.vo;

public class AuthoritiesVo {
	private int authNum;
	private String userId;
	private String authority;
	
	public AuthoritiesVo() {}
	public AuthoritiesVo(int authNum, String userId, String authority) {
		super();
		this.authNum = authNum;
		this.userId = userId;
		this.authority = authority;
	}
	public int getAuthNum() {
		return authNum;
	}
	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
