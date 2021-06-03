package com.yang.empl.vo;

public class PayDeptPositionJoinVo {
	private int payNum;
	private int deptNum;
	private int ppNum;
	private int basepay;
	private String deptName;
	private String ppName;
	public PayDeptPositionJoinVo(int payNum, int deptNum, int ppNum, int basepay, String deptName, String ppName) {
		super();
		this.payNum = payNum;
		this.deptNum = deptNum;
		this.ppNum = ppNum;
		this.basepay = basepay;
		this.deptName = deptName;
		this.ppName = ppName;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public int getPpNum() {
		return ppNum;
	}
	public void setPpNum(int ppNum) {
		this.ppNum = ppNum;
	}
	public int getBasepay() {
		return basepay;
	}
	public void setBasepay(int basepay) {
		this.basepay = basepay;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPpName() {
		return ppName;
	}
	public void setPpName(String ppName) {
		this.ppName = ppName;
	}
}
