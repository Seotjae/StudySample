package chap06.exam01.abs;

public class Person extends Mammal {

	public Person(String name) {
		super(name); //super() 를 통해 부모 클래스 객체화
	}

	public void useTool() {
		System.out.println(name + "가 도구를 사용한다.");
	}
	
	public void social() {
		System.out.println(name + "가 사회생활을 한다.");
	}
	
	public void talk() {
		System.out.println(name + "가 이야기를 한다.");
	}
	
}
