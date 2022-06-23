package chap02.ex09.conExam;

import java.util.Scanner;

public class ConStmt {

	public static void main(String[] args) {
		
		//0~10까지 출력하는 for문 제작
		for (int i = 0; i <= 10; i++) {
			if (i==3) {
				continue;
			}
			System.out.println(i);
		}
		
		
		//0~10까지 출력, 3의 배수만 무시하도록
		for (int i = 0; i <= 10; i++) {
			if (i%3==0) {
				continue;
			}
			System.out.println(i);
		}
			
	}

}
