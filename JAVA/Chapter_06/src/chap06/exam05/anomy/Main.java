package chap06.exam05.anomy;

public class Main {

	public static void main(String[] args) {
		
		//익명객체는 객체의 이름이 없다 = 원형 클래스가 없다. -> 즉석에서 만들기 때문
		//여기에서만 사용할 것이라 이름을 정할 필요가 없다 -> 1회성으로 만들고 사라진다 -> 여기외에서는 사용 못한다.
		
		//일반객체는 객체의 원형 클래스가 있다 -> 항상 존재한다.
		//여기 말고 다른곳에서도 객체화 해서 쓸 수 있다.
		
		//CommonImpl을 객체화 하여
		//test1, tes2 실행
		CommonImpl com = new CommonImpl();
		com.test1();
		com.test2();
		
		
		
		//인터페이스 객체화 -> 익명 객체, 객체는 클래스 명이 있는데 얘는 없다.
		//생활 속에서 이름이 필요한 경우와 필요 없는 경우
		//일회성 만남일 경우 이름이 필요없다.
		//계속 이름이 불리고 만나야 할 경우 이름이 필요하다.
		Common com1 = new Common() {	
			@Override
			public void test2() {
				System.out.println("test4");
			}
			
			@Override
			public void test1() {
				System.out.println("test3");
			}
		};
		
		com1.test1();
		com1.test2();
		
	}

}
