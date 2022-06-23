package chap10.exam09.wait;

public class WorkThread extends Thread {

	private WorkObj obj;
	
	public WorkThread(WorkObj obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			obj.work();
		}
	}
	
	
	
}
