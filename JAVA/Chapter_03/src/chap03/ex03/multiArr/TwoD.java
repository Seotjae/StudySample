package chap03.ex03.multiArr;

public class TwoD {

	public static void main(String[] args) {
		//2개 층 3개 호 아파트가 생겼습니다. 이름은 arr 아파트
		int arr[][] = {
			{00, 01, 02},
			{10, 11, 12}
		};
		
		//4개 층 4개 호 아파트가 생겼습니다. 이름은 royal
		String[][] royal = new String[4][5];
		//"0층0호"
		for (int i = 0; i < royal.length; i++) {//royal의 층 (1차원)
			for (int j = 0; j < royal[i].length; j++) {//royal의 i층에 대한 호 (2차원)
				royal[i][j]=i+"층"+j+"호";
				System.out.println(royal[i][j]);
			}
		}
		
		
		
	}

}
   