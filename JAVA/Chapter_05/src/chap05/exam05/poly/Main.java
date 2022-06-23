package chap05.exam05.poly;

public class Main {

	public static void main(String[] args) {

		//첫째부터 다섯째 까지를 객체화 하여 useRoom()을 실행 해 보자
		Child one = new Child();
		one.useRoom();
		
		ChildTwo two = new ChildTwo();
		two.useRoom();
		
		ChildThree three = new ChildThree();
		three.useRoom();
		
		ChildFour four = new ChildFour();
		four.useRoom();
		
		ChildFive five = new ChildFive();
		five.useRoom();
		
		//만약 자식이 30개라면 변수 선언만 해도 엄청난 노력이 들어간다.
		System.out.println();
		//그래서 다형성을 사용한다.
		//다형성을 사용해 하나의 변수에 여러개의 객체를 수용 할 수 있다.
		ParentHouse house = null;
		house = new Child();
		house.useRoom();
		
		house = new ChildTwo();
		house.useRoom();

		house = new ChildThree();
		house.useRoom();

		house = new ChildFour();
		house.useRoom();

		house = new ChildFive();
		house.useRoom();

		
		
	}

}
