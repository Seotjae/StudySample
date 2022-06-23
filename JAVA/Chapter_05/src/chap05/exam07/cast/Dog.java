package chap05.exam07.cast;

public class Dog extends Mammal {

	@Override
	public void birth() {
		System.out.println("새끼를 세마리 낳는다.");
	}

	public void bark() { //개의 고유 특성
		System.out.println("멍멍!");
	}
	
}
