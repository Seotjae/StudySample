package chap04.ex02.classIns;

public class Main {

	public static void main(String[] args) {
		
		test();
		
		//Student 클래스를 불러온다.
		//Student 클래스가 담기는 이 변수 이름은 std
		//Student 클래스를 복사해서 담고 있다.
		//원본을 보존하기 위해서 복사해서 사용. 
		Student std = new Student(); //클래스 자체가 하나의 자료형(String과 같이)이 될 수 있다.
		//복사 == 객체화 == 인스턴스화
		Student std2 = new Student();
		System.out.println(std);
		System.out.println(std2);
		
		
		
		
	}//
	
	public static void test() {
		System.out.println("test");
	}
}//
