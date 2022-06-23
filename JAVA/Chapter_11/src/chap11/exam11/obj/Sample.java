package chap11.exam11.obj;

import java.io.Serializable;

public class Sample implements Serializable {
	 int num = 11;
	 String team = "dev001";
	 String job = "manager";
	 
	 public String method() {
		return "method 호출하신 분?";
	}
	
	
	
}
