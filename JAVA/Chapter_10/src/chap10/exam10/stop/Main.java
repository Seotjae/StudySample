package chap10.exam10.stop;

public class Main {

	public static void main(String[] args) {
		
		try {
			StopFlag flag = new StopFlag();
			flag.start();
			Thread.sleep(1000);
			flag.setStop(true);
			
			Inter inter = new Inter();
			inter.start();
			Thread.sleep(1000);
			inter.interrupt();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
