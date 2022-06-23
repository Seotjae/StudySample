package chap10.exam08.join;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("1~100 까지의 합은?");
		//OperThread 에게 계산을 시키고
		OperThread oper = new OperThread();
		oper.start();
		
		//Thread.sleep(1000); //효과적이지만 시간차로 인한 시간 loss 발생 우려
		oper.join(); //oper가 다 끝날 때까지 기다렸다가 합류해라

		//MainThread 에게 계산한 내용의 출력을 시킴
		//답이 0이 나온 이유: 계산하는 스레드보다 출력하는 스레드가 더 빨랐기 때문
		System.out.println("답 : " + oper.getSum());
		
	}

}
