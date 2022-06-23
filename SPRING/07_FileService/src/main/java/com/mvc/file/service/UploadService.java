package com.mvc.file.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void upload(MultipartFile uploadFile) { //Controller 의 요청으로 실행 될 upload 메서드 와 보낸 파라메터를 받을 uploadFile
		//1. 파일명 추출		
		String oriFileName = uploadFile.getOriginalFilename(); //컨트롤러가 보낸 파일에서 getOriginalFilename 으로 파일의 원래 이름을 oriFileName에 저장
		//2. 새파일명 작성(업로드한시간을 밀리세컨드로 환산한 값을 파일명으로)
		//2-1. 확장자명 추출
		// oriFileName 에서 가장 마지막에 있는 . 위치의 인덱스 부터 잘라내서 확장자로 만든다.
		String ext = oriFileName.substring(oriFileName.lastIndexOf(".")); //원래 파일명에서 substring과 lastIndexOf 를 사용해서 제일 마지막 . 부터 잘라서 ext 에 담음 (확장자를 추출하는 과정)
		String newFileName = System.currentTimeMillis()+ext; //1000ms 으로 환산한 파일업로드 할 때의 시간과 앞에서 추출한 확장자를 더한 문자열을 새 파일의 이름으로 미리 설정
		logger.info(oriFileName+" => "+newFileName); //원래 파일 이름이 새로운 파일 이름으로 변경 되는 것을 로거로 확인		
		//3. 파일 저장
		
		try { //파일을 읽고 쓰는 과정에서는 예외가 발생할 수 있기 때문에 try-catch 로 예외 처리를 해줌
			byte[] bytes = uploadFile.getBytes();//MultipartFile 을 바이트로 가져 온다. //컨트롤러에게 받은 파일을 getBytes 메서드로 byte 배열 타입으로 변환
			//java.nio
			Path path = Paths.get("C:/upload/"+newFileName);//저장경로 설정 //java nio 의 Paths.get 메서드를 사용해 경로를 생성 (c드라이브의 업로드 폴더에 미리 설정해둔 파일 이름으로 저장하겠다)
			Files.write(path, bytes);//특정 경로(path), 가지고 있는 바이트(bytes) 를 넣는다. //java nio 의 Files 의 write 메서드를 사용해 앞에서 생성한 경로에 바이트로 변환한 파일을 쓰기
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> filelist() {
		ArrayList<String> list = new ArrayList<String>();
		File files[] = new File("C:/upload/").listFiles();//특정 경로의 파일객체들을 불러온다.
		
		for (File file : files) {
			logger.info("file : {}",file.getName());
			list.add(file.getName());
		}				
		return list;
	}

	public void fileDelete(String file) {
		File delFile = new File("C:/upload/"+file);
		if(delFile.exists()) {
			delFile.delete();
		}
		
	}

	public int multiupload(MultipartFile[] files) {
		int cnt = 0;
		//배열에서 Multipartfile 을 하나씩 꺼내 업로드 요청
		for (MultipartFile file : files) {
			upload(file);
			logger.info("파일 업로드 요청!");
			cnt++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return cnt;
		
	}

}
















