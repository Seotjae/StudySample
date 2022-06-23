package chap04.ex10.readOnly;

public class Person {

	final String nation;
	//static final 은 초기화가 안된다.
	//그래서 그냥 선언과 동시에 값을 주는 방법 외엔 없다.
	static final String ssn = ""; //상수라 초기화도 안되기 때문에 초기에 값을 넣음
	final String name;
	
	//final은 시작과 동시에 값을 정해 주면 변경이 불가하다.
	//그래서 선언시 값을 넣어줘야 한다.
	//또는 선언시 값을 넣지 않았다면 생성자를 통해서 초기화 해줘야 한다.
	public Person(String nation, String name) {
		this.nation = nation;
		this.name = name;
		
	}

}
