package chap10.exam06.state;

public class WorkThread extends Thread {

	@Override
	public void run() {
		
		//실행 -> 1.5초 휴식 -> 실행 -> 종료
		try {
			int cnt = 0;
			for (int i = 0; i < 10000000; i++) {
				cnt++;
			}
			
			Thread.sleep(1500);
			
			cnt = 0;
			for (int i = 0; i < 10000000; i++) {
				cnt++;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
