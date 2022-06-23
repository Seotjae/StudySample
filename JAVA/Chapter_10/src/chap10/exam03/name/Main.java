package chap10.exam03.name;

public class Main {

	public static void main(String[] args) {
		
		//스레드 3개 생성 후 실행
		Thread thA = new WorkThread();
		Thread thB = new WorkThread();
		Thread thC = new WorkThread();
		
		thA.start(); //thread-0
		thA.setName("첫째 스레드");
		
		thB.start(); //thread-1
		
		thC.start(); //thread-2
		thC.setName("막내 스레드");
		
	}

}
