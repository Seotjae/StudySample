package chap04.ex03.myApi;

public class Main {

	public static void main(String[] args) {
		
		MyApiClass api = new MyApiClass(); //자동완성 기능 사용
		int result = api.plus(3, 5); //return이 있기 때문에 반환값을 담을 변수 필요
		System.out.println(result);
	}

}
