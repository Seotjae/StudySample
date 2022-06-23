package chap03.ex03.multiArr;

public class ThreeD {

	public static void main(String[] args) {
		//4층 4호 방 3개 짜리 royal 아파트
		String[][][] royal = new String[4][4][3];
		
//		System.out.println(royal.length); //royal 아파트는 몇 층인가
//		System.out.println(royal[3].length); //3층에는 몇개의 호가 존재 하는가?
//		System.out.println(royal[3][2].length); //3층 2호는 방이 몇개 인가?
		
		
		royal[2][3][2] = "철수의 방"; //2층 3호 2번 방은 "철수의 방"
		royal[2][3][0] = "영희의 방";//2층 3호 0번 방은 "영희의 방"
//		//이 두개를 뺀 나머지 방에 "공실" 이라는 값을 넣어 보자.
//		for (int i = 0; i < royal.length; i++) {
//			for (int j = 0; j < royal[i].length; j++) {
//				for (int j2 = 0; j2 < royal[i][j].length; j2++) {		
//					if (i==2 && j==3 && (j2==0 || j2==2)) {
//						continue;					
//					}
//					royal[i][j][j2]="공실";
//				}
//			}
//		}
		
		
		for (int i = 0; i < royal.length; i++) {
			for (int j = 0; j < royal[i].length; j++) {
				for (int j2 = 0; j2 < royal[i][j].length; j2++) {		
					//System.out.println("[" + i + "]" + "[" +j + "]" + "[" +j2+"] = "+royal[i][j][j2]);
					if (royal[i][j][j2] == null) { //방이 비어있다면
						royal[i][j][j2] = "공실"; //"공실" 이라는 값을 넣는다
					}
					System.out.println("[" + i + "]" + "[" + j + "]" + "[" + j2 + "] = " + royal[i][j][j2]);
				
				}
			}
		}
		
		
		
		
		
	}//

}//
