package com.react.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReactController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "{connect:'OK'}";
	}
	
	//get 방식으로 아이디 중복체크 하는 경우
	@RequestMapping(value = "/overlay/{id}", method = RequestMethod.GET)
	public HashMap<String, Object> getOver(@PathVariable String id) {
		logger.info("받아온 내용 : {}",id);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("use",true);
		return result;
	}
	
	//post 방식으로 아이디 중복체크 하는 경우
	//axios 나 ajax 에서 파라미터를 post 방식을 통해 JSON 형태로 보내오면 아래와 같이 처리해야 한다.
	@RequestMapping(value = "/overlay", method = RequestMethod.POST)
	public HashMap<String, Object> postOver(@RequestBody HashMap<String,Object> param) {
		logger.info("받아온 내용 : {}",param);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("use",true);
		return result;
	}
	
	//ajax 에서 file 받을 경우
	//포스트만 받고 싶을 경우
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public HashMap<String, Object> upload(MultipartFile file){
		HashMap<String, Object> result = new HashMap<String, Object>();
		String oriFileName = file.getOriginalFilename();
		logger.info("file name : "+oriFileName);
		//파일명 수정은 생략, 이 경우 같은 파일명이 있을 경우 덮어쓰게 된다.	
		try {
			byte[] bytes= file.getBytes(); //file 정보에서 바이너리 추출
			Path path = Paths.get("C:/upload/"+oriFileName);//어디에 저장할지?
			Files.write(path, bytes); //저장
			result.put("path", "/photoFile/"+oriFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
