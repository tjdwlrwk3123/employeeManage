package com.yang.empl.vo;

public class DepartmentVo {
	private int deptNum;
	private String deptName;
	public DepartmentVo(int deptNum, String deptName) {
		super();
		this.deptNum = deptNum;
		this.deptName = deptName;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
