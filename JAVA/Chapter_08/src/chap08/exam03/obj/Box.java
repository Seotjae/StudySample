package chap08.exam03.obj;

public class Box {

	private Object value; //뭐가 들어올지 몰라서 모든걸 수용하는 Object로 받는다.

	public Object getValue() { //private이라  alt + shift + s 로 게터 세터 만들어서 우회 접근
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
	
	
}
