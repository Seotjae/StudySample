package chap10.exam05.sync;

public class Computer {
	
	private int score;

//	public void setScore(int score) {
//		this.score = score;
//		try {
//			Thread.sleep(2000);
//			System.out.println(Thread.currentThread().getName() + " : " + this.score);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	//동기화 메서드-> 메서드 자체에 여러 스레드가 들어갈 수 없음
//	public synchronized void setScore(int score) { 
//		this.score = score;
//		try {
//			Thread.sleep(2000);
//			System.out.println(Thread.currentThread().getName() + " : " + this.score);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	//동기화 블록 -> 메서드까지는 들어올 수 있으나 특정 영역에는 하나의 메서드만 허용
	public void setScore(int score) { //이 안에는 어떤 스레드든 들어갈 수 있음
		
		synchronized (this) { //여기서부터는 사용 중이면 못 들어감
			this.score = score;			
			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " : " + this.score);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	

	

}
