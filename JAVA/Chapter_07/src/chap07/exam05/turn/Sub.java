package chap07.exam05.turn;

public class Sub {
	
	//4. 그랬더니 main에게 전가
	void method1() throws NumberFormatException {
		method2(); //2. method2에게 일을 시켰다.
	}
	
	//3. 일하다 생긴 문제를 method1에게 전가.
	void method2() throws NumberFormatException {
		Integer.parseInt("a1234");
	}
	
	
	
	
}
