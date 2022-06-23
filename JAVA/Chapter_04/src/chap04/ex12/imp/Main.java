package chap04.ex12.imp;

import chap04.ex07.methodOver.Calculator;

public class Main {

	public static void main(String[] args) {
		//Info 클래스를 객체화 하여 age와 job을 출력 해 보자
		//Info는 같은 패키지이기 때문에 import문을 사용하지 않는다.
		Info info = new Info(); //Info 클래스를 객체화
		System.out.println(info.age);
		System.out.println(info.job);
		
		//Calculator는 다른 패키지에 있으므로 import문 사용...
		Calculator cal = new Calculator(); 
		//하지만 plus 메서드를 사용할 수 없다?
		System.out.println(cal.plus("public", "접근 제한자"));
		
		
	}

}
