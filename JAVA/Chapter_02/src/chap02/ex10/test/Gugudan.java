package chap02.ex10.test;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		//원하는 단수를 입력 받아 구구단을 만들어 본다.
		System.out.println("단수를 선택 하세요.");
		Scanner scan = new Scanner(System.in); //scan이라는 키보드 입력을 가져오겠다.
		int num = scan.nextInt(); //scan을 item 변수에 저장하겠다.
		System.out.println("당신이 선택한 단수: " + num + "단");
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(num + " X " + i + " = " + num*i);
		}
	

		
	}
}	
	

