package chap11.exam13.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyEx {

	public static void main(String[] args) throws IOException {
		System.out.println("복사 시작");
		//1. 읽어올 경로
		Path from = Paths.get("C:/img/dog.jpg");
		
		//2. 내보낼 경로
		Path to = Paths.get("C:/img/temp/copy.jpg");
		
		//3. 읽어오기 //4. 내보내기 -> copy로 한번에
		//같은 이름의 파일이 있을 때 옵션
		//REPLACE_EXISTING: 이미 있는 파일이면 덮어써라
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("복사 종료");

	}

}
