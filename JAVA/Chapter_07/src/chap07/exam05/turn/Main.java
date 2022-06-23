package chap07.exam05.turn;

public class Main {

	//5. main도 처리하기 싫으니 JVM에게 전가 -> JVM에서는 그냥 예외내용과 위치만 알려주고 끝낸다.
	public static void main(String[] args) throws NumberFormatException {
		
		Sub sub = new Sub();
		sub.method1(); // 1. main에서 method1에게 일을 시켰다.
		
	}

}
