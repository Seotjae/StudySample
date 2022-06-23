package chap10.exam01.runnable;

public class Job implements Runnable {

	@Override
	public void run() { //스레드가 해야할 일을 여기에 적는다 -> 이 메서드는 밖의 영향을 받으면 안된다, 만들어둔 메서드를 동작시키는 일을 주로 한다
		for (int i = 0; i < 5; i++) {
			System.out.println("워크 스레드가 하는일 : " + i);
			try { //따라서 throw가 없고 try/catch
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
