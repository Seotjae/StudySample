package chap10.exam09.wait;

public class Main {

	public static void main(String[] args) {
		WorkObj obj = new WorkObj();
		
		//다형성 사용시 문제점
		WorkThread thA = new WorkThread(obj); //new WorkObj 사용시 문제점
		WorkThread thB = new WorkThread(obj);
		thA.start();
		thB.start();
		//순차적으로 나오는 과정
	}

}
