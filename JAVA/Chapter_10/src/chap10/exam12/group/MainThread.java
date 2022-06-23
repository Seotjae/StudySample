package chap10.exam12.group;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		//스레드 그룹 생성 (기본 부모 그룹: main)
		ThreadGroup group = new ThreadGroup("myGroup");
		
		//스레드 생성
		WorkThread thA = new WorkThread(group, "threadA");
		WorkThread thB = new WorkThread(group, "threadB");
		
		//스레드 실행
		thA.start();
		thB.start();
		
		Thread.sleep(3000);
		group.interrupt();
	}
	
}
