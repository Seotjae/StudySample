package chap02.ex05.elseState;

import java.util.Scanner;

public class Japangi {

	public static void main(String[] args) {
		//[콜라:2000,생수:500,오렌지주스:1000,사이다:1000,에너지음료:1500,이온음료:1000,냉커피:1000,식혜:1000]
		
		System.out.println("원하는 아이템을 선택 하세요.");
		Scanner scan1 = new Scanner(System.in); //scan1이라는 키보드 입력을 가져오겠다.
		String item  = scan1.nextLine(); //첫번째 키보드 입력값을 item에 저장한다.
		
		System.out.println("돈을 넣으세요.");
		Scanner scan2 = new Scanner(System.in); //scan2이라는 키보드 입력을 가져오겠다.
		int money = scan2.nextInt(); //두번째 키보드 입력값을 money에 저장한다.
		
		System.out.println(item + "/" + money);
		int change = 0; //잔돈을 담을 변수를 선언한다.

		if (item.equals("콜라") && money >= 2000) { //item의 값이 문자열 콜라와 같고 money의 값이 2000보다 크거나 같다면
			change = money - 2000; 
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)"); //이 문장을 출력한다.
		}else if (item.equals("콜라") && money < 2000) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("생수") && money >= 500) {
			change = money - 500;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("생수") && money < 500) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("오렌지주스") && money >= 1000) {
			change = money - 1000;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("오렌지주스") && money < 1000) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("사이다") && money >= 1000) {
			change = money - 1000;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("사이다") && money < 1000) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("에너지음료") && money >= 1500) {
			change = money - 1500;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("에너지음료") && money < 1500) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("이온음료") && money >= 1000) {
			change = money - 1000;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("이온음료") && money < 1000) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("냉커피") && money >= 1000) {
			change = money - 1000;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("냉커피") && money < 1000) {
			System.out.println("금액이 부족합니다.");
			
		}else if (item.equals("식혜") && money >= 1000) {
			change = money - 1000;
			System.out.println(item + "가 나왔습니다. (잔액: " + change + "원)");
		}else if (item.equals("식혜") && money < 1000) {
			System.out.println("금액이 부족합니다.");
			
		}else {
			System.out.println(item + "는 보유하고 있지 않습니다.");
		}
	}
}

