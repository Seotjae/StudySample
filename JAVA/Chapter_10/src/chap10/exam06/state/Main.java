package chap10.exam06.state;

public class Main {
	
	private static Thread.State state;

	public static void main(String[] args) {
		
		//워크 스레드에게 일을 시킴
		WorkThread work = new WorkThread();
		
		//그걸 감시
		while (true) {
			state = work.getState();
			System.out.println("Thread State : " + state);
			
			if (state == Thread.State.NEW) {
				work.start();
			}
			
			if (state == Thread.State.TERMINATED) {
				break;
			}
		}

	}

}
