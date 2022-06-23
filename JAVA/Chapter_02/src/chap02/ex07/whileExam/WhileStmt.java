package chap02.ex07.whileExam;

public class WhileStmt {

	public static void main(String[] args) {
		//while은 조건이 만족되면 계속 반복 한다.
		int i = 0;
		
		//while은 기본적으로 조건을 넣어줘야 한다.
		while (i<=10) {
			i++;
			System.out.println(i);			
		}
		
		
		
		//조건에 true가 들어갈 경우... break 조건을 만들어 준다.
		i=0;
		while(true) {//조건이 true면 무한 루프에 빠진다.
			i++;
			System.out.println("영원히 반복: " + i);
			if (i>=10) {
				break;
			}			
		}
		//un reach able code : 닿지 않는 코드, 위 구문대로라면 아래 구문에 도달할 수 없다는 오류.
		//해결방법1: 아래코드를 지워준다.
		//해결방법2: 위 while문을 탈출할 수 있는 조건을 만들어 준다.
		//int cup = i; 
		
		

	}

}
