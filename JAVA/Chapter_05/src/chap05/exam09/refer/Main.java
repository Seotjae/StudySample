package chap05.exam09.refer;

public class Main {

	public static void main(String[] args) {
		
		//레이서를 부른다.
		Racer racer = new Racer();
		//차량을 가져온다.
		Car car = new Ferrari();
		//레이서에게 차량을 준다.
		racer.drive(car);
		//변수에 한번 담아서 쓰면 확인 절차를 가질 수 있고
		//다른 곳에서도 쓸 수 있다.
		
		//하지만 바로 넣으면 편리하다.
		//ex: 라면에 계란을 바로 넣느냐 그릇에 한번 깨보고 넣느냐
		racer.drive(new McLaren());
		racer.drive(new Maserati());
	}

}
