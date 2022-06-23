package chap10.exam04.priority;

public class WorkThread extends Thread {

	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		
		System.out.println(getName() + " 작업 시작");
		for (int i = 0; i < 10000000; i++) {
			//작업한다고 가정
		}
		System.out.println(getName() + " 작업 끝");
		
		
	}
	
	
	
}
