package chap05.exam09.refer;

public class Racer {
	
	//Car car = new Car();
	
	//종류가 차량이기만 하면 뭐든 운전할 수 있다.
	//Ferrari, McLaren, Maserati 모두 Car를 상속 받았다.
	//그래서 매개변수 타입을 Car로 선언하면 다 들어올 수 있다.
	//이렇게 매개변수에 다형성을 사용하면 매개변수 다형성이다.
	public void drive(Car car) {
		car.run();
	}
	
	//만약 다형성을 활용하지 않는다면 아래처럼 각 차량마다 메서드를 추가해야 한다.
	//차량이 수십가지 였다면 수십가지 메서드를 추가해야함
	public void drive(McLaren mac) {
		mac.run();
	}
	
	public void drive(Maserati maserati) {
		maserati.run();
	}
	
	public void drive(Ferrari ferrari) {
		ferrari.run();
	}
	
}
