package chap11.exam12.props;

import java.io.BufferedOutputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropWrite {

	public static void main(String[] args) throws Exception {
		//파일 쓰기
		//주 스트림 준비, 경로 설정
		String path = "src/chap11/exam12/props/profile.properties";
		FileOutputStream fos = new FileOutputStream(path);
		
		//보조 스트림 준비
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//쓰기
		//1) properties 객체화
		Properties props = new Properties();
		//2) properties 객체에 값을 담음 (웬만하면 한글 사용 안함)
		props.put("id", "admin");
		props.put("pw", "pass");
		props.put("name", "최성재");
		//3) 저장
		props.store(bos, "simple comment"); //OutputStream, 파일에 남길 간단한 주석
		
		//스트림 비우기, 자원 반납
		//bos.flush(); -> Properties에서 알아서 해준다
		bos.close();
		
		
	}

}
