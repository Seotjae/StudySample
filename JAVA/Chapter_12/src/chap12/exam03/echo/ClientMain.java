package chap12.exam03.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		//1. socket 생성 == 접속 요청
		Socket socket = new Socket("4.tcp.ngrok.io", 12715);
		System.out.println("접속 완료");
		//2. 할 일 요청
		//스트림을 이용해서 문자 읽어오고 보내기
		//1) 스트림 준비, 경로 지정
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		//2) 쓰기, flush()
		oos.writeUTF("Hello Server, 최성재");
		oos.flush();
		//3) 읽어오기
		InputStream is = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		String msg = ois.readUTF();
		System.out.println("Server Response: " + msg);
		//3. 끝났으면 자원 반납
		socket.close();
		
	}

}
