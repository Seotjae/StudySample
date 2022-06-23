package chap10.exam07.yield;

public class ThreadA extends Thread {
	
	boolean stop = false;
	boolean yield = false;
	
	@Override
	public void run() {
		
		while (!stop) { //stop 플래그
			System.out.println("ThreadA 동작");
			
			//B도 실행할 수 있는 기회를 줌
			if (yield) {
				System.out.println("ThreadB 에게 양보");
				Thread.yield(); //할 수 있는 기회를 한번 준다. 바로 응답하지 못하면 내가 한다.
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadA 중지");
	}

	
}
