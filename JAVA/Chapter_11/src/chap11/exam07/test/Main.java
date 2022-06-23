package chap11.exam07.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		//1. 내보낼 파일 위치 지정
		String outputPath = "C:/img/temp/sample.txt";
		
		//2.
		Scanner scan = new Scanner(System.in);
		
		//3. 내보낼 스트림
		FileWriter fw = new FileWriter(outputPath, true);
		
		//4. 내보내는 내용
		System.out.print("입력: ");
		String str = scan.nextLine();
		fw.write(str + "\r\n");
		
		//5. 자원 반납
		fw.flush();
		fw.close();

	}

}
