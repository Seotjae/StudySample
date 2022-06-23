package chap07.exam04.exception;

public class ClassCastException {

	public static void main(String[] args) {
		
		//부모 형태에서 자신의 형태로 되돌아갈 때 잘못된 형태로 캐스팅할 경우
		Object obj = 1234;
//		int val = (int) obj; //본래 숫자였는데 문자로 되돌아 가려고 하면 안됨
//		System.out.println(val);
		
		//위 예외를 피하기 위한 코드
		if (obj instanceof String) { //obj에 들어있는 값이 String 이야?
			String val = (String) obj;
		} else {
			System.out.println("val은 String이 아니네요.");
		}
		
		
	}

}
