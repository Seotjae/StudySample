package com.beans;

//자바에서 공통으로 사용되는 데이터 : bean / DTO(Data Transfer object) / VO (부르는 명칭이 다 다름)
public class FirstBean {
	//beans 규약 : 빈의 멤버 변수는 반드시 private 으로 만든다
	private String name = "hong, gil-dong";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
