package chap11.exam09.buffer;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferNotUse {

	public static void main(String[] args) throws IOException { //파일 복사
		
		//1. 파일위치 지정
		String src = "C:/img/dog.jpg";
		String dst = "C:/img/temp/copy.jpg";
		
		//2. 스트림 준비
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		
		//시간 측정
		TimeChecker check = new TimeChecker();
		check.timeStart();
		
		//3. 읽어오기
		//byte[] data = new byte[1024];
		int data;
		int i = 0;
		while ((data = fis.read()) != -1) {
			i++;
			System.out.println("복사 중" + i);
			fos.write(data); //4. 쓰기
		}
		System.out.println("버퍼 미사용: " + check.timeStop() + "ms"); //32,424ms
		
		//5. 자원반납
		fos.flush();
		fis.close();
		fos.close();
		
	}

}
