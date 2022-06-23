package chap06.exam01.abs;

public class Main {

	public static void main(String[] args) {

		Person person = new Person("영희");
		person.birth();
		person.eat();
		
		person.useTool();
		person.social();
		person.talk();
		
		/* 추상 클래스는 외부에서 객체화 할 수 없다. -> 오직 자식만 객체화 가능.
		Mammal mal = new Mammal("") {
		};
		*/
	}

}
