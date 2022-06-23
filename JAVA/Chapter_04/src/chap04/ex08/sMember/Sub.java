package chap04.ex08.sMember;

public class Sub {

	//static은 객체화를 해도 복사되지 않는다.
	
	static int sField = 134;

	static int plus (int a, int b) {
		return a+b;
	}
	
	static int minus (int a, int b) {
		return a-b;
	}

	//객체화 시 복사가 된다.
	int multi (int a, int b) {
		return a*b;
	}

}


//Sub 클래스 객체화 시 multi는 복사되어 heap으로 static이 붙은 나머지는 복사가 안되고 static에 그대로
