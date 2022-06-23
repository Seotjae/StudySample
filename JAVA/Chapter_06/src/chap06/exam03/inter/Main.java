package chap06.exam03.inter;

public class Main {

	public static void main(String[] args) {
		
		//Window를 객체화 해서
		//click과 dblclick 실행
		MouseEvent mouse = new Window();
		mouse.click(1);
		mouse.dblclick(2);
		
		mouse = new Linux();
		mouse.click(1);
		mouse.dblclick(2);
		
		mouse = new Mac();
		mouse.click(1);
		mouse.dblclick(2);
		
		mouse.wheel(1); //현재 mouse 객체는 Mac인데 인터페이스 메서드가 사용된다? -> 상속처럼 구현받은 인터페이스의 default 메서드는 내 것처럼 사용 가능
		
		MouseEvent.setDpi(1000); //static은 직접 접근해야 한다.
		
		
	}

}
