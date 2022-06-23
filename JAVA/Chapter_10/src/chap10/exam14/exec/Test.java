package chap10.exam14.exec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		//1
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		//2 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread Pool" + Thread.currentThread().getName());	
			}
		};
		
		//3
		for (int i = 1; i <= 10; i++) {
			pool.execute(runnable);
		}
		
		//4
		pool.shutdown();
		//pool.shutdownNow(); 
//		try {
//			pool.awaitTermination(10, TimeUnit.SECONDS); 
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 

	}

}
