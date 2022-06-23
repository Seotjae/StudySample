package chap10.exam04.priority;

public class Main {

	public static void main(String[] args) {
		//우선순위는 1부터 10까지 줄 수 있음 -> 높을수록 우선순위 높음
		//우선순위가 없거나 같으면 빠른놈이 먼저
		Thread th = null;
		for (int i = 1; i <= 5; i++) {
			th = new WorkThread(i + "번 스레드");
			th.setPriority(i+5); //우선순위 6~10
			th.start();
		}
		//우선순위만으로는 확실하게 순서를 제어할 수 없음 -> 경향성만 줌

	}

}
