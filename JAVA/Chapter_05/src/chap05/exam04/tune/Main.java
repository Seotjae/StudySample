package chap05.exam04.tune;

public class Main {

	public static void main(String[] args) {
		
		MyCar car = new MyCar();
		car.start();
		System.out.println("차가 시속 "+ car.run() + "km로 달린다.");

		car.turbo = true;
		System.out.println("차가 시속 "+ car.run() + "km로 달린다.");

		car.stop();
		
		
	}

}
