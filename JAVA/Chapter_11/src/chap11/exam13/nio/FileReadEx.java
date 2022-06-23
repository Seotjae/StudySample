package chap11.exam13.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadEx {

	public static void main(String[] args) throws IOException {
		//파일 읽기 순서
		//경로 설정
		Path path = Paths.get("C:/img/temp/test.txt");
		
		//주 스트림 준비 + 보조 스트림
		//-> channel 사용
		
		//읽어오기
		List<String> lines = Files.readAllLines(path); //실제 파일의 한 줄을 읽어와서 List에 넣음
		for (String string : lines) {
			System.out.println(string);
		}
		
//		for (int i = 0; i < lines.size(); i++) {
//			System.out.println(lines.get(i));
//		}
		
		//자원반납
		//->쓴 자원이 없어서 반납도 없음
		
		
	}

}
