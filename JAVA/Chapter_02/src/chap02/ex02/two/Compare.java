package chap02.ex02.two;

public class Compare {

	public static void main(String[] args) {
		// 비교 연산은 항상 왼쪽을 기준으로 한다
		
		//대입연산
		int v1 = 1;
		double v2 = 0.1;
		int v3 = 4;
		String v4 = "JAVA";
		String v5 = new String("JAVA");
		System.out.println(v4);
		System.out.println(v5);
		
		
		//비교연산
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);
		System.out.println(v1 < v3);
		System.out.println(v4 == v5);
		//문자열(String)이 같은지 비교 할때는 equals 라는 메서드를 사용 한다
		System.out.println(v4.equals(v5));
		
		
		//논리연산 (AND &&, OR ||)
		int val = 6;
		
		if (val>1 && val<7) {
			System.out.println("val은 1보다 크고 7보다 작네요!");
		}
		
		if (val%2==0 || val%3==0) {
			System.out.println("val은 2의 배수 또는 3의 배수 입니다.");
		}
		
		//id가 admin이고, pw가 pass 일 경우 로그인이 되는 상황을 만들어 보자
		String id = "admin";
		String pw = "pass";
		
		if (id.equals("admin") && pw.equals("pass")) {
			System.out.println("로그인 완료");
		}
	}
}
