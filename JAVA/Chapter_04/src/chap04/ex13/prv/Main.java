package chap04.ex13.prv;

public class Main {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		
		com.setPower(true);
		if (com.getPower() == true) {
			System.out.println("전원이 켜져 있습니다.");
		}else {
			System.out.println("전원이 꺼져 있습니다.");
		}
		
		System.out.println("현재 팬속도: " + com.getPanSpeed());
		com.setPanSpeed(50);
		System.out.println("현재 팬속도: " + com.getPanSpeed());
		
		System.out.println("현재 온도: " + com.getTemp());
		
		
		
		
		
	}

}
