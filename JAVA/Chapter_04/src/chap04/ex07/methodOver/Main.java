package chap04.ex07.methodOver;

public class Main {

	public static void main(String[] args) {
		
		/* 메서드 오버로드: 같은 이름으로 여러 메서드를 만들수 있는것
		 * 좋은점: 한가지 이름으로  여러 인자값을 받을수 있다.
		 * (사용자에게 ooo메서드만 쓰시면 됩니다. 라고 배포 할 수 있다.)
		 * 결국엔 사용자를 위한 기능이다.
		 */
		
		
		Calculator cal = new Calculator(); //Calculator 클래스를 객체화
		
		//선택은 plus(int, int)로 했지만 매개변수에 값을 넣으면
		//알아서 해당 메서드로 찾아 간다.
		System.out.println(cal.plus("method", "overload")); //plus 메소드 출력
		
		
		
		
		
	}

}
