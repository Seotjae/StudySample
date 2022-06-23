package chap10.exam02.thread;

public class AnonyMain {

	public static void main(String[] args) {
		
		//work thread 
		Thread work = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					System.out.println("work thread - " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}
		};
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
