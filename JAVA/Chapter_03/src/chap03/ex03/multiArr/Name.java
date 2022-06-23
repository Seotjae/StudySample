package chap03.ex03.multiArr;

public class Name {

	public static void main(String[] args) {
		
		int[] score = {70, 80, 90, 100};
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i + "] = " + score[i]);
		}
		
		for (int i : score) { //향상된 for문은 배열 종류에만 사용 가능
			System.out.println(i);
		}
		
		
		
	}

}
