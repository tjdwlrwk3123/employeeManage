package com.yang.empl.vo;

public class ImageVo {
	private int imgNum;
	private String img;
	public ImageVo(int imgNum, String img) {
		super();
		this.imgNum = imgNum;
		this.img = img;
	}
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
