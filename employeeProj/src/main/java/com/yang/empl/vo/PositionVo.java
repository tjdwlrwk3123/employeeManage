package com.yang.empl.vo;

public class PositionVo {
	private int ppNum;
	private String ppName;
	private int basepay;
	public PositionVo(int ppNum, String ppName, int basepay) {
		super();
		this.ppNum = ppNum;
		this.ppName = ppName;
		this.basepay = basepay;
	}
	public int getPpNum() {
		return ppNum;
	}
	public void setPpNum(int ppNum) {
		this.ppNum = ppNum;
	}
	public String getPpName() {
		return ppName;
	}
	public void setPpName(String ppName) {
		this.ppName = ppName;
	}
	public int getBasepay() {
		return basepay;
	}
	public void setBasepay(int basepay) {
		this.basepay = basepay;
	}
}
