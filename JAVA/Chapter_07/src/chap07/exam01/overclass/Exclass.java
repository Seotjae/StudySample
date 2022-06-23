package chap07.exam01.overclass;

public class Exclass {

	public Exclass() {
		System.out.println("외부 클래스 객체 생성");
		
	}

	//1. 인스턴스 멤버 클래스 - 전형적인 내부 클래스
	public class InsClass{
		
		int field;
		
		public InsClass() {
			System.out.println("인스턴스 멤버 클래스 객체 생성");
		}
		
		void method() {
			System.out.println(field + "을 출력하는 메서드 실행");
		}
		
	}


	//2. 정적 멤버 클래스 - 상위 클래스를 객체화 하면 사용 못함
	public static class StaticClass {
		
		public StaticClass() {
			System.out.println("static class 객체화");
		}
		int field;
		
		void method() {
			System.out.println(field + "을 출력하는 메서드 실행");
		}
		
		static int stField;
		
		static void stMethod() {
			System.out.println(stField + "을 출력하는 static method 실행");
		}
	
	}

	
	//3. 로컬 인스턴스 클래스 - 메서드 안에서만 사용 가능
	void localMethod() {
		class Local {
			public Local() {
				System.out.println("Local 객체 생성");
			}
			
			int field;
			
			void method() {
				System.out.println(field + "을 출력하는 메서드 실행");
			}
		}
		
		//메서드 안에 선언된 클래스는 메서드 안에서만 사용 가능하다.
		Local local = new Local();
		local.field = 300;
		local.method();
	
	}	
}	

