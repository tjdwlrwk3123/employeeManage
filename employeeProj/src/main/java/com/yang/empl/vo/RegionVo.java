package com.yang.empl.vo;

public class RegionVo {
	private int regionNum;
	private String regionName;
	public RegionVo(int regionNum, String regionName) {
		super();
		this.regionNum = regionNum;
		this.regionName = regionName;
	}
	public int getRegionNum() {
		return regionNum;
	}
	public void setRegionNum(int regionNum) {
		this.regionNum = regionNum;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
