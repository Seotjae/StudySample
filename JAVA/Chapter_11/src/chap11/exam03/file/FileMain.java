package chap11.exam03.file;

import java.io.File;
import java.io.IOException;

public class FileMain {

	public static void main(String[] args) throws IOException {
		//폴더 만들기
		File dir = new File("C:/img/temp"); //만들고 싶은 파일이나 폴더 경로
		if (!dir.exists()) {
			System.out.println("폴더 없음, 폴더 생성");
			dir.mkdirs();
		}
		
		//폴더 안에 파일 만들기
		File file = new File("C:/img/temp/text.txt");
		if (!file.exists()) {
			System.out.println("파일 없음, 파일 생성");
			boolean success = file.createNewFile();
			System.out.println("파일 생성 여부: " + success);
		}
		
		//폴더의 정보 확인
		File info = new File("C:/img");
		//파일명 알아보기
		String[] fileNames = info.list();
		for (String name : fileNames) {
			System.out.println(name);
		}
		
		//파일에 대한 기타 정보 확인
		File[] files = info.listFiles();
		for (File f : files) {
			boolean isDir = f.isDirectory(); //디렉토리 여부 확인
			String gubun = isDir ? "[디렉토리]" : "[파일]";
			System.out.println(gubun + " " + f.getName() + " " + (f.length()/1024) + " KB");
			
			
			
		}
	}

}
