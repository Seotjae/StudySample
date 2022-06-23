package chap05.exam04.tune;

public class MyCar extends ParentCar {
	//Override는 상속받은 메서드가 마음에 들지 않을 때 변경해서 쓰는 것
	//상속받은 메서드를 재정의 하는 것
	
	//기존의 부모 메서드를 무시하고 완전히 다시 만드는 것 (alt+shift+s, 또는 상단탭 source)
//	@Override
//	public int run() {
//		//return super.run();//부모의 메서드를 그대로 사용하겠다는 것
//		return 180; 
//	
//	}
	
	//기존의 부모 메서드를 이용하되 약간 변경한 경우
	boolean turbo = false;

	@Override
	public int run() {
		
		if (turbo == true) {
			return 200;
		} else {
			return super.run();
		}
	
	}
	 
	
}
