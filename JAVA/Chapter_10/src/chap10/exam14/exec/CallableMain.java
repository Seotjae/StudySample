package chap10.exam14.exec;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1. 스레드 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		//2. Callable로 해야할 일 생성
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("callable 처리");
				return "처리완료"; //callable은 return이 있다.
			}
		};
		
		//3. 작업 실행
		Future<String> result = pool.submit(callable);
		System.out.println(result.get()); //반환 값 꺼내오기
		
		//4. 스레드 풀 종료 (더 이상 스레드를 쓸 일이 없을 때)
		
		
		
		
		
	}

}
