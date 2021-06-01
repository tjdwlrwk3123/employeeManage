package com.yang.empl.vo;

import java.sql.Date;

public class EmpListVo {
	private int empNum;
	private String userId;
	private String empName;
	private int ppNum;
	private int deptNum;
	private Date empBirth;
	private int solarlunar;
	private int regionNum;
	private String contactAdress;
	private int basepay;
	private int bonus;
	private Date joinday;
	public EmpListVo(int empNum, String userId, String empName, int ppNum, int deptNum, Date empBirth, int solarlunar,
			int regionNum, String contactAdress, int basepay, int bonus, Date joinday) {
		super();
		this.empNum = empNum;
		this.userId = userId;
		this.empName = empName;
		this.ppNum = ppNum;
		this.deptNum = deptNum;
		this.empBirth = empBirth;
		this.solarlunar = solarlunar;
		this.regionNum = regionNum;
		this.contactAdress = contactAdress;
		this.basepay = basepay;
		this.bonus = bonus;
		this.joinday = joinday;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getPpNum() {
		return ppNum;
	}
	public void setPpNum(int ppNum) {
		this.ppNum = ppNum;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public Date getEmpBirth() {
		return empBirth;
	}
	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}
	public int getSolarlunar() {
		return solarlunar;
	}
	public void setSolarlunar(int solarlunar) {
		this.solarlunar = solarlunar;
	}
	public int getRegionNum() {
		return regionNum;
	}
	public void setRegionNum(int regionNum) {
		this.regionNum = regionNum;
	}
	public String getContactAdress() {
		return contactAdress;
	}
	public void setContactAdress(String contactAdress) {
		this.contactAdress = contactAdress;
	}
	public int getBasepay() {
		return basepay;
	}
	public void setBasepay(int basepay) {
		this.basepay = basepay;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public Date getJoinday() {
		return joinday;
	}
	public void setJoinday(Date joinday) {
		this.joinday = joinday;
	}
}
