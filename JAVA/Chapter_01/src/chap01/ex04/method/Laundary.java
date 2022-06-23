package chap01.ex04.method;

public class Laundary {

	public static void main(String[] args) { //return 문이 없으면 void
		//main 메서드는 무언가를 동작 해 주는 일을 한다.
		//메서드 사용법 : 부르면 된다. (호출 == call)
		String 바구니 = "더러운 빨래"; //1.바구니에 더러운 빨래를 담음
		String 정리바구니 = 세탁기(바구니); //2.빨랫감(=바구니에 든 더러운 빨래)을 세탁기에 넣고 작동 //6.세탁된 옷을 정리바구니에 담김
		System.out.println(정리바구니); //7.빨래가 되었는지 확인
	}

	
	public static String 세탁기(String 빨랫감) { //3.세탁기 작동
		//4.아래 내용 실행
		//System.out.println(빨랫감 + "를 세탁한다.");
		//System.out.println(빨랫감 + "를 탈수");
		return "깨끗해진 옷"; //5.바구니에 있던 더러운 빨래가 세탁이 되어서 깨끗해진 옷으로 나옴
	}
	
	
}
