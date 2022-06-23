package chap11.exam05.fileoutput;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputMain {

	public static void main(String[] args) throws IOException {
		//1. 읽어올 파일 위치와 내보낼 파일 위치 지정
		String oriPath = "C:/img/dog.jpg";
		String targetPath = "C:/img/temp/image.jpg";
		
		//2. 스트림 준비 (파일 객체화는 생략 가능)
		FileInputStream fis = new FileInputStream(oriPath);
		FileOutputStream fos = new FileOutputStream(targetPath, false); //true면 기존 파일에 붙여 쓰겠다.
		
		//3. 읽어오기
//		int data;
//		int i = 0; //성능 체크
//		while ((data = fis.read()) != -1) { //성능이 좋지 않음, 양동이에 있는 물을 티스푼으로 퍼나르는 상황, 1byte 씩 넣고
//			i++;
//			System.out.println("파일 복사중 " + i); //2,828,924
//			fos.write(data); //4. data에 있는 값 쓰기
//		}
		//3. 성능향상 읽어오기
		int i =0;
		byte[] arr = new byte[1024]; //티스푼 1024개 분량의 컵 준비
		while (fis.read(arr) != -1) { //읽어들인 내용을 인자값으로 제공된 arr에 담아둠
			fos.write(arr);
			i++;
			System.out.println("파일 복사중 " + i); //2,763
		}
		
		//4. 사용한 자원 닫기 (flush 포함)
		fos.flush();
		fis.close();
		fos.close();
		
		
	}

}
