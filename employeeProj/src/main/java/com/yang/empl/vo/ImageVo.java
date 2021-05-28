package com.yang.empl.vo;

public class ImageVo {
	private int imgNum;
	private int empNum;
	private String img;
	public ImageVo(int imgNum, int empNum, String img) {
		super();
		this.imgNum = imgNum;
		this.empNum = empNum;
		this.img = img;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
