package chap12.exam02.tcp;

import java.io.IOException;
import java.net.Socket;
//import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws IOException {
		//1. 소켓 준비 -> 접속 요청
		Socket socket = null;
		try {
			socket = new Socket("4.tcp.ngrok.io", 12715);
			//2. 이 경우 예외가 발생하지 않으면 성공
			System.out.println("접속 성공");
			//3. 할 일이 있으면 요청 (현재는 없엄)
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
		finally {
			//4. 자원 반납 -> 성공하든 실패하든 무조건, 소켓을 다시 생성해야하기 때문
			socket.close();
		}
		
		
		
		
	}

}
