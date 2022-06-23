package chap11.exam12.props;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

public class PropeRead {

	public static void main(String[] args) throws Exception {
		//파일 읽어오기
		//주 스트림 준비, 경로 지정
		String path = "src/chap11/exam12/props/sample.properties";
		
		//보조 스트림 준비
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//읽어오기
		//1) properties 객체 생성
		Properties props = new Properties();
		//2) 스트림을 이용해 읽어오기
		props.load(bis);
		//3) 읽어온 내용 출력
		for (Object key : props.keySet()) {
			System.out.println(key + ": " + props.get(key));
		}
		
		//자원반납
		bis.close();
		
		
	}

}
