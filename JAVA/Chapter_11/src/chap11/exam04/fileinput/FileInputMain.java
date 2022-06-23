package chap11.exam04.fileinput;

//안쓰는 import 지우기 (shift+alt+o) -> 지우기보단 주석처리 권장
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputMain {

	public static void main(String[] args) throws IOException {
		//1. 읽어올 파일의 경로 지정
		String path = "C:/img/temp/text.txt";
		
		//2. 파일을 자바에서 다루기 위한 File 객체화
		File file = new File(path);
		
		//3. InputStream 준비
//		FileInputStream fis = new FileInputStream(file); //바이트 기반 -> 한글이 깨질 수 있다.
		FileReader fis = new FileReader(file); //텍스트 기반
		
		//4. 읽어오기
		int data;
		while ((data = fis.read()) != -1) { //-1 -> 에러, 못찾음, 끝(EoF)
			System.out.print((char)data);
		}
		
		//5. 사용한 자원 반납
		fis.close();
		
	}

}
