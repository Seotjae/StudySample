package chap10.exam14.exec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableMain {

	public static void main(String[] args) throws InterruptedException {
		//1. 스레드 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		//2. Runnable로 해야할 일 생성
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("runnable 처리");
				
			}
		};
		
		//3. 작업 실행 -> pool에서는 start()가 없음
		pool.execute(runnable);
		//pool.submit(runnable);
		
		//4. 스레드 풀 종료 (더 이상 스레드를 쓸 일이 없을 때)
		pool.shutdown();
		//pool.shutdownNow();
		//boolean end = pool.awaitTermination(10, TimeUnit.SECONDS);
		
		
		
		
	}

}
