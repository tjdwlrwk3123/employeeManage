package com.yang.empl.vo;

public class PayforVo {
	private int payNum;
	private int deptNum;
	private int ppNum;
	private int basepay;
	public PayforVo(int payNum, int deptNum, int ppNum, int basepay) {
		super();
		this.payNum = payNum;
		this.deptNum = deptNum;
		this.ppNum = ppNum;
		this.basepay = basepay;
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
}
