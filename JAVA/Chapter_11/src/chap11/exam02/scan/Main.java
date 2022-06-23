package chap11.exam02.scan;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner를 준비, 입력받은 내용 출력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("문자열 입력>");
		String inputStr = scan.nextLine();
		System.out.println(inputStr);
		
		//정수
		System.out.print("정수 입력>");
		int inputInt = scan.nextInt();
		System.out.println(inputInt);
		//실수
		System.out.print("실수 입력>");
		double inputDouble = scan.nextDouble();
		System.out.println(inputDouble);
	}
	

}
