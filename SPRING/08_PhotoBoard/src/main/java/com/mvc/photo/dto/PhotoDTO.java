package com.mvc.photo.dto;

import java.util.Date;

//DTO 에는 보여주고 싶은 내용만 넣어도 된다
public class PhotoDTO {

	private int fileIdx;
	private String oriFileName;
	private String newFileName;
//	private int idx;
//	private Date reg_date;
	
	public int getFileIdx() {
		return fileIdx;
	}
	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
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
	
	
	
	
	
}
