package chap03.ex02.value;

public class Output {

	public static void main(String[] args) {
		
		int[] score = new int[10];
		
		for (int i = 0; i < score.length; i++) {
			score[i] = (i+1)*10;
			//System.out.println("score[" + i + "] = "+ score[i]);
		}
		
//		System.out.println(score[0]);//0번방
//		System.out.println(score[5]);//5번방
//		System.out.println(score[9]);//9번방
		
		for (int i = 0; i < score.length; i++) {
			//System.out.println(score[i]);
			System.out.println("score[" + i + "] = "+ score[i]);
		}
		
		
//		score[0] = 10;
//		score[1] = 20;
//		score[2] = 30;
//		score[3] = 40;
//		score[4] = 50;
//		score[5] = 60;
//		score[6] = 70;
//		score[7] = 80;
//		score[8] = 90;
//		score[9] = 100;
		
	
	
	}//

}//
