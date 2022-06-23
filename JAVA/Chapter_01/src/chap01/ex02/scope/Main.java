package chap01.ex02.scope;

public class Main {

	String str = "아무거나 입력 하세요"; //클래스 안에서 사용 가능
	
	public static void main(String[] args) { //벽{} (영역)
		
		int num = 123; //main 메서드 안에서 사용 가능
		
		for (int i = 0; i < 5; i++) {
			//num은 for 문에서도 사용 가능(생긴곳이 for 문보다 밖이니깐)
			int sum = num + i; //sum은 밖으로 가지고 나갈 수 없다.
		}
	}

}
