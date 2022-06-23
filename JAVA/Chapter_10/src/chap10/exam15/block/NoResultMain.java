package chap10.exam15.block;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("작업처리: " + i);
				}
				
			}
		};
		
		//pool.execute(run);
		//반환값이 없더라도 blocking을 위해서 submit 사용
		Future result = pool.submit(run);
		result.get();
		
		System.out.println("작업 완료");
		pool.shutdownNow();

	}

}
