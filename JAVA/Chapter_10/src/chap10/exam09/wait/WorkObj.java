package chap10.exam09.wait;

public class WorkObj {
	
	//ooo이 실행 -> 다른 스레드 깨우기 -> 나는 쉼
	//wait(), notify(), notifyAll() 호출은 synchronized 안에서 해야 제대로 동작
	//만약 synchronized 아니라면 동시진입해서 wait()이 되어버릴 수 있음
	public synchronized void work() {
		System.out.println(Thread.currentThread().getName() + " 이 실행");
		notify(); //다른 스레드를 깨우고
		
		try {
			wait(); //스스로 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
