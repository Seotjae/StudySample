package chap04.ex06.memberCall;

public class Car {

	int gear = 0;
	boolean on = false;
	
	public Car() {
		
	}
	
	void start() {
		System.out.println("시동을 걸었습니다.");
		
		if (on == true) {
			System.out.println("시동이 이미 걸려 있습니다.");
		}else {
			this.on = true;
		}
	}
	
	void change(int gear) {
		System.out.println("기어를 " + gear + "단으로 변속.");
		this.gear = gear;
	}
	
	
}
