package chap05.exam07.cast;

public class Cast {

	public static void main(String[] args) {

		Mammal mal = null;	
		
		mal = new Dog();
		//promotion을 이용하면 Dog의 특성이 사라진다.
		//그래서 bark()를 사용 할 수 있다.
		mal.birth(); //부모에게 받은 메서드(오버라이드 포함)는 사용 가능.
		
		mal = new Cat();
		mal.birth();
		
		//오버라이드를 사용하면 다형성에 의해 부모 형태로 돌아가도 나만의 무언가를 가질 수 있다.
		
		//그러면 자신의 특성을 활용하고 싶다면??
		//자신의 집으로 돌아가야 한다.
		Cat cat = (Cat) mal;
		cat.mew();
		
		//캐스팅시 주의점
		//돌아갈 객체가 무엇이였는지 알아야 한다. (부모님 집에서 내 집으로 돌아갈때 옆집으로 돌아가면 안된다.)
		//돌아가야 할 객체가 원래 무엇이였는지 와 원래 있던 곳이 어딘지 알아야 한다.
		//돌아가야 할 원형을 기억하고 있어야 한다.
		
	}

}
