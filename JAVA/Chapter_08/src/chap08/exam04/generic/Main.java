package chap08.exam04.generic;

public class Main {

	public static void main(String[] args) {
		
		//박스 준비 (어떤 걸 담을지 정해라)
		//조건: 클래스 타입으로 지정해야 함
		Box<Integer> box = new Box<Integer>(); //T는 클래스 타입으로 넣어야함
		box.setValue(123);
		
		//택배가 왔다.
		//이미 뭐가 들어있는지 알기 때문에 받아서 쓰면 된다.
		int val = box.getValue();
		System.out.println(val);
		
		
	}

}
