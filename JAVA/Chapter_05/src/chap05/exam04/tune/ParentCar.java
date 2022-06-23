package chap05.exam04.tune;

public class ParentCar {

	public void start() {
		System.out.println("시동을 건다.");
	}
	
	public int run() {
		return 60;
	}
	
	public void stop() {
		System.out.println("멈춘다.");
	}
	
	//final은 수정이 불가능 하기에 오버라이드 할 수 없다.
	public final void test() {
		System.out.println("자체 점검");
	}
	
}
