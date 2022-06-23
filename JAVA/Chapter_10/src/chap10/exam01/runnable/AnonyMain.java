package chap10.exam01.runnable;

public class AnonyMain {

	public static void main(String[] args) throws InterruptedException {
		//워크 스레드 (익명객체)
		Thread work = new Thread(new Runnable() {	
			@Override
			public void run() {
				for (int i = 0; i <= 5; i++) {
					System.out.println("work thread - " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		//work 실행
		work.start();
		
		//메인 스레드에서 하는 일
		for (int i = 0; i <= 5; i++) {
			System.out.println("main thread - " + i);
			Thread.sleep(500);
		}

	}

}
