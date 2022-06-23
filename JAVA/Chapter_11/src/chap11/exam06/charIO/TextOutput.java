package chap11.exam06.charIO;

import java.io.FileWriter;
import java.io.IOException;

public class TextOutput {

	public static void main(String[] args) throws IOException {
		//1. 내보낼 파일 위치 지정
		String outputPath = "C:/img/temp/test.txt";
		
		//2. 내보낼 스트림 준비
		FileWriter fw = new FileWriter(outputPath, true);
		System.out.println("저장 시작");
		
		//3. 쓰기
		fw.write("for 문 시작 전 \r\n");
		for (int i = 1; i <= 10; i++) {
			fw.write("for 문 증가 : " + i + "\r\n");
		}
		fw.write("for 문 종료 \r\n");
		
		//4. 자원 반납(flush 필수)
		fw.flush();
		fw.close();
		System.out.println("저장 완료");

	}

}
