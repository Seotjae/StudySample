package chap02.ex03.three;

public class Score {

	public static void main(String[] args) {
		//3항 연산자는 조건에 따라서 변수의 값이 달라진다.
		//조건이 맞냐? 맞으면:틀리면
		//score 85보다 크면 A 아니면 B
		int score = 75;
		char grade = score>90 ? 'A' : 'B';
		System.out.println(score + "는 " + grade + " 등급 입니다.");
		
		//score가 85보다 크면 A 아니면...  80보다 크면 B 아니면 C
		char grade1 = score>85 ? 'A' : score>80 ? 'B' : 'c';
		System.out.println(score + "는 " + grade1 + " 등급 입니다.");
		
		String str1 = "a";
		String grades = score>90 ? "A" : "B";
		
	
	}

	

	}

