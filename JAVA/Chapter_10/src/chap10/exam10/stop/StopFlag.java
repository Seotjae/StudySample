package chap10.exam10.stop;

public class StopFlag extends Thread {
	
	private boolean stop = false;

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		
		while (!stop) {
			System.out.println("StopFlag 실행중");
		}
		System.out.println("종료하기 전 준비");
		System.out.println("종료");
	}
	
	
	
	
}
