package chap10.exam07.yield;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//yield는 자기자신이 쉬겠다는 의미가 아님
		//다른 스레드도 실행할 수 있는 기회를 양보 하는 것 (해볼래?)
		//A와 B를 실행 -> A에 양보하라고 함 -> 0.5초 후 -> B에게 양보하라고 함 -> 0.5초 후 -> 종료
		ThreadA thA = new ThreadA();
		ThreadB thB = new ThreadB();
		//AB 실행
		thA.start();
		thB.start();
		
		//A에게 양보 명령
		thA.yield = true;
		
		//0.5초 
		Thread.sleep(500);
		
		//A 양보 취소, B에게 양보 명령
		thA.yield = false;
		thB.yield = true;
		
		//0.5초 후
		Thread.sleep(500);
		
		//종료
		thA.stop = true;
		thB.stop = true;

	}

}
