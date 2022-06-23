package chap02.ex06.forExam;

public class ForStmt {

	public static void main(String[] args) {
		
		
		//for(이녀석이;이것을 만족한다면;증가 또는 감소)
		//for는 반복 횟수가 정해진 경우 적합하다.
		
		//물 10잔 떠오기
		
	
		for (int i = 0; i < 10; i++) {
			System.out.println("물 " + (i+1) + "잔");
		}
		
		for (int i = 1; i < 11; i++) {
			System.out.println("물 " + i + "잔");
		}
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("물 " + i + "잔");
		}
		
		
		//물 한 잔에 커피 2스푼 => 총 10잔의 커피를 만들어라
		//i가 10회 반복되고, i가 10회 반복 될 동안 i 1회당 j가 2회 반복된다.
		for (int i = 1; i < 11; i++) {
			System.out.println("물 " + i + "잔에");
			for (int j = 1; j <= 2; j++) {
				System.out.println("커피 " + j + "스푼을 넣는다.");
			}
		System.out.println("완성된 커피: " + i + "잔");
		
		}
		
		//2단 ~ 9단
		for (int i = 2; i <= 9; i++) {
			System.out.println("==== " + i + "단 시작 ====");
			for (int j = 1; j <= 9; j++) {
				//int result = i * j;
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println("==== " + i + "단   끝  ====");
		}
		
		
		
		
	}

}
