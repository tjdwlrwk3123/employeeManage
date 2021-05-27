package com.yang.empl.vo;

import java.sql.Date;

public class EmplListVo {
	private int empNum;
	private String empName;
	private Date empBirth;
	private int solarlunar;
	private String contactAdress;
	private int bonus;
	public EmplListVo(int empNum, String empName, Date empBirth, int solarlunar, String contactAdress, int bonus) {
		super();
		this.empNum = empNum;
		this.empName = empName;
		this.empBirth = empBirth;
		this.solarlunar = solarlunar;
		this.contactAdress = contactAdress;
		this.bonus = bonus;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getContactAdress() {
		return contactAdress;
	}
	public void setContactAdress(String contactAdress) {
		this.contactAdress = contactAdress;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
