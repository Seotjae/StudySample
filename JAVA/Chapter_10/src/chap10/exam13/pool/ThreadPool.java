package chap10.exam13.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		//스레드 풀 생성 방법
		//1개 이상 스레드가 반납되었을 때 60초 이상 놀고 있으면 스레드를 제거
		//EX: 스케이트 대여소를 열고 기다림, 미리 만들어 둔 건 없음 -> 요청이 오면 만들어서 빌려줌
		//요청이 왔을 때 반납받은 스케이트가 있으면 그걸로 빌려준다, 없으면 만들어서 빌려줌
		//60초 이상 반납받은 스케이트를 아무도 안 빌려 가면 없앰
		ExecutorService pool1 = Executors.newCachedThreadPool();
		
		//위와 기본적으로 같으나 다른점 한가지: 스레드를 유지하는 개수가 있음
		int n = Runtime.getRuntime().availableProcessors(); //CPU에서 사용 가능한 Main Thread 수
		System.out.println("main thread: " + n);
		ExecutorService pool2 = Executors.newFixedThreadPool(n); //어느 pc에서 적용될 지 모름 -> pc사양에 맞춰 값 넣음

	}

}
