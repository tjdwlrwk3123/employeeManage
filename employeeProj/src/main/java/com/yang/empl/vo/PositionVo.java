package com.yang.empl.vo;

public class PositionVo {
	private int ppNum;
	private String ppName;
	public PositionVo(int ppNum, String ppName) {
		super();
		this.ppNum = ppNum;
		this.ppName = ppName;
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
}
