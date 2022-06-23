package chap04.ex09.sBlock;

public class Monitor {

	static String company = "SAMSUNG";
	static String model = "Wide Curved Monitor";
	static int price; //초기 값이 없다.
	
	//static은 객체화 하지 않기 때문에 생성자로 초기화가 불가능 하다.
	//그래서 static block을 사용한다.
	static {//bracket == code block
		//class가 static 영역에 올라갈때(원본이 생성 될 때) 실행
		System.out.println("초기화");
		price = 2500000;
	}
	
}
