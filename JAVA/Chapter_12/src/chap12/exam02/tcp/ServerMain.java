package chap12.exam02.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		//1. ServerSoket 생성
		ServerSocket server = null;
		
		try {
			//각 프로그램은 고유의 포트를 가지고 있음, 이게 겹치면 안됨
			server = new ServerSocket(5001); //내 IP의 5001번 방을 염
			
			while (true) {//2. Client 요청 대기
				System.out.println("요청 대기중...");
				//3. 요청이 오면 수락 (클라이언트의 소켓을 받는다)
				Socket socket = server.accept(); //blocking 기능에 의해서 반환값이 나올 때까지 대기
				//4. 해야할 일 (들어온 사람이 누군지 출력)
				InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress(); //remote는 원격지 의미 (떨어져 있는 녀석)
				System.out.println("접속 완료>" + addr.getAddress() + ":" + addr.getPort());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			//5. 자원 반납 (서버를 닫는 일) -> 예외 발생 시 서버를 닫음
			server.close();
			System.out.println("예외 발생으로 서버를 종료 합니다.");
		}
		
	}

}
