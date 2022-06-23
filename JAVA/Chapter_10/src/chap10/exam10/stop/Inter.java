package chap10.exam10.stop;

public class Inter extends Thread {

	@Override
	public void run() {
		//interrupt()를 이용한 방법1
//		try {
//			while (true) {
//				//InterruptException을 강제로 발생시켜 반복문을 정지시키는 방식
//				//예외처리를 위해 sleep이 들어가야해서 번거로움
//				System.out.println("Inter 실행중");
//				//InterruptException 발생 조건을 만들기 위해 굳이 넣어줘야 함
//				Thread.sleep(1); 
//			}
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			System.out.println("종료 준비");
//			System.out.println("종료");	
//		}
		
		//interrupt()를 이용한 방법2
		while (true) {
			System.out.println("Inter 실행중v2");
			//스레드가 인터럽트에 걸렸는지 확인해서 걸렸으면 break;
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("종료 준비");
		System.out.println("종료");
		
		
	}
	

}
