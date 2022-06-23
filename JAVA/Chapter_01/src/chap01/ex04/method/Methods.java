package chap01.ex04.method;

public class Methods {

	public static void main(String[] args) {
		int 동전 = 500;
		String 봉투 = 자판기(동전);
		System.out.println(봉투);
		
		저금통(동전);
		String 손 = 번호표기계();
		System.out.println(손);
		호출벨();
	}
	
	
	
	//매개변수 : O, 반환값 : O
	public static String 자판기(int 동전) {
		return "해당하는 물건";
	}
	
	//매개변수 : O, 반환값 : X
	public static void 저금통(int 동전) {
	System.out.println(동전 + "원을 저장한다.");
	}
		
	//매개변수 : X, 반환값 : O
	public static String 번호표기계() {
		return "번호표";
	}
	
	//매개변수 : X, 반환값 : X
	public static void 호출벨() {
		System.out.println("띵동~!!!");
	}
	
	
	
	
	
	
}
