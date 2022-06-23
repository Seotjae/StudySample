package chap02.ex07.whileExam;

public class DoWhile {

	public static void main(String[] args) {
		
		
		int cnt = 11;
		
		while(cnt<10) {
			cnt++;
		}
		System.out.println("while cnt: " + cnt);
		
		cnt = 11;
		do {
			cnt++;
		} while (cnt<10);
		System.out.println("do while cnt: " + cnt);
		
		//do while은 do에서 실행한 값을 가지고 다음 실행 여부를 판단.
		//cnt를 11로 만들어서 반복조건을 만족시키지 않는다면?
		//do while은 조건이 맞던 안맞던 일단은 실행 시킨다.
		//while은 원래 값이 조건에 맞으면 실행하고, do while은 원래 값을 우선 실행하고 값이 조건에 맞는지 확인. 
		
		

	}

}
