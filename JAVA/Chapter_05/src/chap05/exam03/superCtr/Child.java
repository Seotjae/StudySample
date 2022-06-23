package chap05.exam03.superCtr;

public class Child extends Parent {

	public String field;
	
	//Child 생성시 3개의 인자값을 받아서
	public Child(String attr1, int attr2, String field) { //자식 객체 초기화
		super(attr1, attr2); //2개는 부모님 드리고
		this.field = field; //1개는 내가 쓰고
	
	
	}

}
