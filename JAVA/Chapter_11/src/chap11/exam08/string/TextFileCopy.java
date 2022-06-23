package chap11.exam08.string;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TextFileCopy {

	public static void main(String[] args) throws IOException {
		
		//C:/img/temp/test.txt -> C:\img\copy.txt
		//1. 파일 경로 지정
		String src = "C:/img/temp/test.txt";
		String dst = "C:/img/copy.txt";
		
		//2. 스트림 준비
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		//2-1. 보조스트림 준비
		InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
		OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
		
		//3. 읽어오기
		char[] arr = new char[1024];
		int data;
		while ((data = reader.read(arr)) != -1) {
			System.out.println(data);
			writer.write(arr); //4. 쓰기
			arr = new char[1024];
		}
		
		//5. 자원반납
		writer.flush();
		
		reader.close();
		writer.close();
		
	}

}
