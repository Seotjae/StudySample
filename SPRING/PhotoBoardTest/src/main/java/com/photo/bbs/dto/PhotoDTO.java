package com.photo.bbs.dto;

import java.util.Date;

public class PhotoDTO {
	
	private int filedx;
	private String oriFileName;
	private String newFileName;
	private int idx;
	private Date reg_date;
	
	
	public int getFiledx() {
		return filedx;
	}
	public void setFiledx(int filedx) {
		this.filedx = filedx;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
	
}
