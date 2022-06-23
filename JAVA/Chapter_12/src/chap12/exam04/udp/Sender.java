package chap12.exam04.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Sender {

	public static void main(String[] args) throws Exception {
		//1. DatagramSocket 생성
		DatagramSocket socket = new DatagramSocket();
		//2. 보낼 메시지 준비
		for (int i = 1; i <= 3; i++) {
			String msg = "data-" + i;
			//3. DatagramPacket에 메시지 담기 (배열, 배열의 길이, 주소)
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, new InetSocketAddress("localhost", 5001));
			//4. 데이터 발송
			socket.send(packet);
		}
		//5. 자원 정리
		socket.close();
		
	}

}
