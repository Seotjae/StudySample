package chap08.exam08.gmethod;

public class GMethod {
	
	//제너릭은 타입을 이용하면 매개변수 타입이 사용시 마다 유동적으로 변한다.
	public <T> void method1(T t) {
		System.out.println("입력값 t: " + t);
	}
	
	//받은 내용과 반환 타입을 동일하게
	public <T> T method2(T t) {
		return t;
	}
	
	//매개변수 타입에 따라 반환되는 Box 객체의 type이 달라진다.
	public <T>  Box<T> method3(T t) {
		
		Box<T> box = new Box<T>();
		box.setT(t);
		
		return box;
	}
	
}
