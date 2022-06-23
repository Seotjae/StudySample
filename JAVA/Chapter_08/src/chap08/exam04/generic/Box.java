package chap08.exam04.generic;

public class Box<T> {//값이 어떤 것이 들어올지 모른다.

	private T value; //T: 값을 넣을 때 type을 지정해 주겠다.

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
}
