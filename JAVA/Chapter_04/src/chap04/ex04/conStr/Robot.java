package chap04.ex04.conStr;

public class Robot {

	public String name;
	public String goal;
	
	public Robot(String name, String goal) {
		System.out.println("이 클래스가 객체화 되면 이걸 제일 먼저 실행");
		
		//변수의 영역이 서로 다르면 같은 이름을 써도 문제 없다.
		
		this.name = name; //이 클래스에 원래 있던 변수임을  표시해주기 위해서 this 사용
		this.goal = goal; //원래 있던 변수에 받아온 변수를 넣겠다
	}

	//생성자 오버로드: 생성자를 같은 이름으로 여러개 만들수 있다.
	//조건: 매개변수의 수가 다르거나, 타입이 달라야 한다.
	//객체화를 다양하게 하기 위해서 사용 (이름만 넣거나, 안넣거나, 이름과 할일을 같이 넣거나 등)
	public Robot(String name) {
		this.name = name;
	}
	
	/* 기존 생성자와 매개변수의 갯수도 같고 타입도 같다.
	public Robot(String goal) {
		
	}
	*/
	
	public Robot() {
		
	}

	
}//
