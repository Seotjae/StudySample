package chap02.ex05.elseState;

import java.util.Scanner;

public class StmtSwitch {

	public static void main(String[] args) {
		
		
		System.out.println("음료를 선택 하세요.");
		Scanner scan = new Scanner(System.in);
		String item = scan.nextLine();
		System.out.println("당신이 선택한 음료: " + item);
		
		/*
		 * switch문은 if문보다 속도가 우수하다.
		 * 하지만 if와 같은 조건(비교연산자 && 나 || 같은)을 사용할 수 없다.
		 * 그래서 복잡한 조건에는 사용할 수 없다.
		 */
		
		switch (item) {//key(item)에는 비교대상이 들어감, item의 값을 비교하겠다.
			case "콜라": //key 값(item)이 value("콜라")이면~ (JDK 1.7 밑으로는 문자열이 안된다.), item의 값이 문자열 콜라라면
				System.out.println(item + "가 나왔습니다."); //이 문장을 출력한다.
				break; //프로그램은 기본적으로 {}문장영역 안에 있는 내용을 모두 실행한다. 따라서 break가 없으면 아래 내용이 계속 실행 된다. break를 만나 중괄호를 빠져나감
				
			case "생수": 
				System.out.println(item + "가 나왔습니다.");
				break;
				
			case "오렌지주스": 
				System.out.println(item + "가 나왔습니다.");
				break;
				
			default: //위의 case의 어느 것에도 해당하지 않을 경우 (=else)
				System.out.println(item + "는 없습니다.");
				break;
		}
		
		
//		if (item.equals("콜라")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("생수")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("오렌지주스")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("사이다")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("에너지음료")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("이온음료")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("냉커피")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else if (item.equals("식혜")) {
//			System.out.println(item + "가 나왔습니다.");
//		}else {
//			System.out.println(item + "는 보유하고 있지 않습니다.");
//		}
		
		
	}

}
