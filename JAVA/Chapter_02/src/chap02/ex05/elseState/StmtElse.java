package chap02.ex05.elseState;

import java.util.Scanner;

public class StmtElse {

	public static void main(String[] args) {
		//자판기에서 음료 뽑기
		//[콜라,생수,오렌지주스,사이다,에너지음료,이온음료,냉커피,식혜]
		
		System.out.println("음료를 선택 하세요.");
		Scanner scan = new Scanner(System.in); //scan이라는 키보드 입력을 가져오겠다.
		String item = scan.nextLine(); //scan을 item 변수에 저장하겠다.
		System.out.println("당신이 선택한 음료: " + item);
		
		if (item.equals("콜라")) { //item 값이 문자열 콜라와 같다면
			System.out.println(item + "가 나왔습니다."); //이렇게 출력해라
		}else if (item.equals("생수")) { //아니면 문자열 생수와 같다면
			System.out.println(item + "가 나왔습니다."); //이렇게 출력해라
		}else if (item.equals("오렌지주스")) { //계속 위와 동일
			System.out.println(item + "가 나왔습니다.");
		}else if (item.equals("사이다")) {
			System.out.println(item + "가 나왔습니다.");
		}else if (item.equals("에너지음료")) {
			System.out.println(item + "가 나왔습니다.");
		}else if (item.equals("이온음료")) {
			System.out.println(item + "가 나왔습니다.");
		}else if (item.equals("냉커피")) {
			System.out.println(item + "가 나왔습니다.");
		}else if (item.equals("식혜")) {
			System.out.println(item + "가 나왔습니다.");
		}else { //item 값이 위의 문자열들과 일치하는 것 없이 그밖이라면
			System.out.println(item + "는 보유하고 있지 않습니다."); //다음과 같이 출력해라.
		}

	}

}
