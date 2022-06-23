package chap05.exam07.cast;

public class Cat extends Mammal {

	@Override //포유류의 속성이지만, 고양이는 새끼를 여러마리 낳기 때문에 Override 해준다.
	public void birth() {
		System.out.println("새끼를 다섯마리 낳는다.");
	}

	public void mew() { //고양이의 고유 특성
		System.out.println("야옹~");
	}
	
	
}
