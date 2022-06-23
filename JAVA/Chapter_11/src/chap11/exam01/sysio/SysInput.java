package chap11.exam01.sysio;

import java.io.IOException;
import java.io.InputStream;

public class SysInput {

	public static void main(String[] args) {
		
		System.out.println("아무거나 입력 하세요");
		InputStream is = System.in; //키보드로부터 입력받음
		
		try {
			int input = is.read(); //입력받은 값을 아스키코드 값으로 받음
			System.out.println("입력 받은 아스키코드 : " + input);
			
			char inputChar = (char) input;
			System.out.println("변환된 문자 : " + inputChar);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
