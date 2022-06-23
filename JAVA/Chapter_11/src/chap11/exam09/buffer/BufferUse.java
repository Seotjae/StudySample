package chap11.exam09.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferUse {

	public static void main(String[] args) throws IOException { //파일 복사
		//1. 파일위치 지정
		String src = "C:/img/dog.jpg";
		String dst = "C:/img/temp/copy.jpg";
		
		//2. 스트림 준비
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		
		//2-1. 보조 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//시간 측정
		TimeChecker check = new TimeChecker();
		check.timeStart();
		
		//3. 읽어오기
		int data;
		int i = 0;
		while ((data = bis.read()) != -1) {
			i++;
			System.out.println("복사 중" + i);
			bos.write(data); //4. 쓰기
		}
//		byte[] data = new byte[1024];
//		while (bis.read(data) != -1) {
//			System.out.println("복사 중" + i);
//			bos.write(data);
//		}
		System.out.println("버퍼 미사용: " + check.timeStop() + "ms"); //23,024ms -> 50ms
		
		//5. 자원반납
		bos.flush();
		bis.close();
		bos.close();
				
	}

}
