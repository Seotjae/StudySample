package chap10.exam12.group;

public class WorkThread extends Thread {

	public WorkThread(ThreadGroup group, String name) {
		super(group, name); //스레드가 소속된 그룹, 스레드의 이름	
	}

	@Override
	public void run() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		System.out.println("현재 스레드 그룹 이름: " + group.getName());
		System.out.println("현재 스레드 이름: " + getName());
		group.list(); //스레드 그룹과 그에 속한 스레드들에 대한 정보 (이름, 우선순위, 그룹, 소속 스레드 정보)
	
	//강제 인터럽트로 정지하기 위해 필요한 것들
	//무한반복, sleep(), interrupt(), interrupted()
	try {
		while (true) {
			System.out.println(getName() + "실행중");
			Thread.sleep(500);
		}		
	} catch (Exception e) {
		System.out.println(e.toString());
		System.out.println("interrupt exception 발생");
		System.out.println(getName() + "종료");
	}
	
	
	
	
	}
	
	
	

}
