package chap10.exam03.name;

public class WorkThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName() + " 스레드가 출력한 내용"); //Thread를 상속받았기 때문에 getName()을 내 것처럼 사용
		}
		
	}
	
	

}
