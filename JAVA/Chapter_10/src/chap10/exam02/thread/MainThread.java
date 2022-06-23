package chap10.exam02.thread;

public class MainThread {

	public static void main(String[] args) {
		
		//work thread
		//해야할 일 생성
		Thread work = new Job();
		//스레드에 전달 -> 스레드를 상속받았기 때문에 인터페이스와 다르게 필요없는 과정
		//스레드 실행
		work.start();
		
		//main thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("main thread - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
