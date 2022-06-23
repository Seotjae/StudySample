package chap01.ex01.define;

public class Main {

	public static void main(String[] args) {
		//주석이 한줄일 경우
		/*주석이 여러개일 경우*/
		
		//타입 이름 = 값;
		boolean varBool = true;
		String varString = "문자열"; //문자열은 문자가 여러개인 것, 더블쿼터(")로 감싸 준다.
		char varchar = 'A'; //문자 딱 1자만 들어감 싱글쿼토(')로 감싸 준다.
		
		//정수 (일반숫자)
		int varInt = 0; //일반적인 정수
		long varLong = 100000000; //큰 정수(연봉 계산 부터는 long)
		
		//실수(소숫점)
		float floatVal = 0.1f; //소숫점은 기본적으로 double로 저장, 그렇게 때문에 float을 쓸때 별도의 표기를 해줘야 한다.
		double doubleVal = 0.00005; // double 은 소숫점 5자리 이상일 경우
		
		System.out.println(floatVal);
	}

}
