package chap06.exam02.absMethod;

public class Concrete extends Abs {

	
	public void child() {
		
	}
	
	//추상 메서드는 추상 클래스를 상속받는 동시에 강제로 오버라이드 한다.
	//추상 메서드의 내용이 없기 때문에 강제로 오버라이드 해야 한다.
	@Override
	public void must1() {

	}

	@Override
	public void must2() {

	}

	//1. 추상 메서드를 왜 써야 하는지? 꼭 필요한 메서드를 강제 할 수 있어서 
	//2. 언제 써야 유요한지? 공통으로 꼭 만들어야하는 기능들을 배포할때
	//ex: 은행 앱에 꼭 들어가야 할 기능을 추상 메서드로 만들어서 추상 클래스로 개발자들에게 나눠준다. 그리고 개발시 그 클래스를 상속 받도록 한다.
	
	
	
	
}
