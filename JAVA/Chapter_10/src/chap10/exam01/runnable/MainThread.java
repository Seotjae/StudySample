package chap10.exam01.runnable;

public class MainThread {

	public static void main(String[] args) { //메인 메서드는 메인 쓰레드를 동작시킨다
		//워크 스레드 생성해서 일 시키기
		//해야 할 일 불러오기
		Runnable job = new Job();
		
		//워크 스레드를 생성해서 전달하기
		Thread work = new Thread(job);
		
		//워크 스레드 실행시키기
		work.start();
		

		//메인 스레드가 하는 일
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 스레드가 하는 일 : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
