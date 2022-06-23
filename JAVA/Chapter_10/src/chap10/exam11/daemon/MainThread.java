package chap10.exam11.daemon;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		DaemonThread demon = new DaemonThread();
		demon.setDaemon(true);
		demon.start();
		
		Thread.sleep(3000);
		
		System.out.println("Main Thread 종료");
		
		
	}

}
