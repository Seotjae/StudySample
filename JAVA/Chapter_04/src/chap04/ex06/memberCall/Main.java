package chap04.ex06.memberCall;

public class Main {

	public static void main(String[] args) {
		Car car = new Car();
		
		//시동걸기
		car.start();
		
		//현재 기어 확인하기
		System.out.println("현재 기어는: " + car.gear + "단.");
		
		//변속하기
		car.change(3);
		
		//다시 시동걸기
		car.start();
		
	}

}
