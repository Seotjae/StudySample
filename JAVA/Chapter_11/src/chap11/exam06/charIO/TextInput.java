package chap11.exam06.charIO;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextInput {

	public static void main(String[] args) throws IOException {
		//1. 읽어올 파일 경로
		String inputPath = "C:/img/temp/text.txt";
		
		//2. Input Stream 준비
		FileReader reader = new FileReader(inputPath);
		
		//3. 읽어오기
//		int data;
//		while ((data = reader.read()) != -1) {
//			System.out.print((char)data);
//		}
		
		char[] arr  = new char[1024];
		while (reader.read(arr) != -1) {
			System.out.print(arr);
			//문자열은 바이트처럼 1024로 떨어지지 않기 때문에 
			//기존 데이터가 들어가면 기존 데이터가 그대로 남아있는 현상 발생
			//그래서 한번 쓰고난 배열을 초기화
			arr = new char[1024]; 
		}
		
		
		//4. 자원반납
		reader.close();
		
	}

}
