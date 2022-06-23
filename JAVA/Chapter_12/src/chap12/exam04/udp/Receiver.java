package chap12.exam04.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) throws Exception {
		//UDP를 사용하기 위해서는 DatagramSocket을 사용
		//1. DatagramSocket 생성
		DatagramSocket socket = new DatagramSocket(5001);
		while (true) {
			System.out.println("메시지 수신 대기중");
			//2. 메시지 받을 DatagramPacket 생성
			//받을 배열, 최대 읽을 수 있는 길이
			DatagramPacket packet = new DatagramPacket(new byte[100], 100);
			//3. 데이서 수신
			socket.receive(packet); //뭔가 받으면 안에 넣은 packet에 넣어줌
			byte[] data = packet.getData();
			//4. 데이터 수신 출력
			String str = new String(data, "UTF-8");
			System.out.println(str);
			//5. 자원 정리
			//socket.close();
			
				
		}
			
	}
		
}


