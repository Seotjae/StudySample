package chap05.exam05.poly;

//public은 java파일 이름과 동일한 클래스만 가질 수 있다.
public class Child extends ParentHouse {//첫째

	@Override
	public void useRoom() {
		System.out.println("첫째가 방 하나를 사용한다.");
	} 

}


class ChildTwo extends ParentHouse {//첫째

	@Override
	public void useRoom() {
		System.out.println("둘째가 방 하나를 사용한다.");
	} 

}


class ChildThree extends ParentHouse {//첫째

	@Override
	public void useRoom() {
		System.out.println("셋째가 방 하나를 사용한다.");
	} 

}


class ChildFour extends ParentHouse {//첫째

	@Override
	public void useRoom() {
		System.out.println("넷째가 방 하나를 사용한다.");
	} 

}


class ChildFive extends ParentHouse {//첫째

	@Override
	public void useRoom() {
		System.out.println("다섯째가 방 하나를 사용한다.");
	} 

}