package chap10.exam11.daemon;

public class DaemonThread extends Thread {

	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println("Demon Thread 동작");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
