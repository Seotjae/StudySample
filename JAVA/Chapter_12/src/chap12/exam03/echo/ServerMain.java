package chap12.exam03.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		try {
			server = new ServerSocket(5001); //1. server socket 생성
			while (true) { //2. 요청 대기
				System.out.println("요청 대기중");
				Socket socket = server.accept();//3. 요청 수락
				InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("connect user: " + addr.getPort());
				//4. 할 일 실행
				//스트림을 이용해서 문자 읽어오고 보내기
				//1) 스트림 준비, 경로 지정
				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is); //JAVA 간 통신에서만 사용가능
				//2) 읽어오기
				String msg = ois.readUTF();
				System.out.println("Client Message: " + msg);
				//3) 쓰기, flush()
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeUTF("당신이 보낸 메세지>" + msg);
				oos.flush();
				//4) 자원반납
				ois.close();
				oos.close();
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("서버 종료");
			server.close(); //5. 서버에 문제가 있다면 자원 반납
			e.printStackTrace();
		}
		
		
	

	}

}
