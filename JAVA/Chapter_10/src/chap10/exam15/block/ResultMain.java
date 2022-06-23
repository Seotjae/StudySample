package chap10.exam15.block;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("1~100 까지의 합은?");

		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		Callable<Integer> call = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;
				}
				return sum;
			}
		};
		
		Future<Integer> result = pool.submit(call); //Future 객체를 반환받는 경우
		System.out.println("답: " + result.get()); //get()으로 받을 때까지 메인 스레드가 움직이지 못함
		pool.shutdownNow();
	}

}
