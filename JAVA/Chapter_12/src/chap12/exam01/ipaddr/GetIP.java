package chap12.exam01.ipaddr;

import java.net.InetAddress;
//import java.net.UnknownHostException;

public class GetIP {

	public static void main(String[] args) throws Exception{
		//1. 내 PC의 IP 얻기
		InetAddress addr = InetAddress.getLocalHost(); //localhost는 내 pc를 의미
		System.out.println("내 PC 주소 : " + addr.getHostAddress());
		System.out.println();
		
		//2. 특정 도메인의 IP 얻기1
		String domain = "www.gdu.co.kr";
		addr = InetAddress.getByName(domain);
		System.out.println(addr.getHostAddress());
		System.out.println();
		
		
		//3. 특정 도메인의 IP 얻기2 -> 대형 사이트는 하나의 도메인에 여러 IP를 연결함
		domain = "www.youtube.com";
		InetAddress[] addrs = InetAddress.getAllByName(domain);
		System.out.println(domain + "에 연결된 IP들");
		for (InetAddress ip : addrs) {
			System.out.println(ip.getHostAddress());
		}
		
		
	}

}
