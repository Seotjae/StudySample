package chap11.exam13.nio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileWriteEx {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		//파일 쓰기
		//1. 파일 경로 지정
		Path path = Paths.get("C:/img/write.txt");
		//2. 스트림 준비 (X)
		
		//3. 쓰기
		System.out.print("내용을 입력하세요>");
		Scanner scan = new Scanner(System.in);
		String msg = scan.nextLine();
		msg += "\r\n";
		
		//파일이나 폴더가 없을 경우
		if (Files.notExists(path)) {
			System.out.println("파일이 존재하지 않으므로 생성");
			Files.createFile(path);
		}
		
		Files.write(path, msg.getBytes("UTF-8"), StandardOpenOption.APPEND);
		//APPEND: 파일 쓰기 시 파일의 끝에 추가로 기록됨
		//WRITE: 일반적인 쓰기 모드
		//CREATE: 파일이 존재하지 않을 경우 새 파일 생성
		//CREATE_NEW: 이미 파일이 존재할 경우 다른 이름으로 생성
		
		//4. 스트림 비우기, 자원반납 (X)

	}

}
