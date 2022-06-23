package chap03.ex02.value;

public class Input {

	public static void main(String[] args) {
		
		//int 타입인 10개짜리 방 생성, 이름은 score
		int[] score = new int[10];
		System.out.println(score.length);
		
		
		score[0] = 100; //0번 방에 100
		
		score[1] = 50; //1번 방에 50
		
		score[2] = 70; //2번 방에 70
		
		//3번방 부터 9번방 까지 100 넣어보기
		
		for (int i = 3; i < score.length; i++) {
			score[i] = 100;
		}
		
		
//		score[3] = 100;
//		score[4] = 100;
//		score[5] = 100;
//		score[6] = 100;
//		score[7] = 100;
//		score[8] = 100;
//		score[9] = 100;
		
		
		
		
		
		
	}//

}//
