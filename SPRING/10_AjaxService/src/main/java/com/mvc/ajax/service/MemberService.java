package com.mvc.ajax.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ajax.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public HashMap<String, Object> overlay(String id) { //오버레이 메서드가 실행되면
		logger.info("중복확인 서비스 도착");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String overlayId = dao.overlay(id); //dao의 오버레이 메서드를 실행 -> db에서 select 문으로 일치하는 아이디 를 찾아 옴
		logger.info("아이디 중복 여부 : {}",overlayId); //찾아온 아이디 확인
		
		boolean overlay = overlayId == null ? false : true; //찾아온 아이디가 널이라면 false를 반환하고 아니라면 true 를 반환 해서 오버레이변수에 담음
		
		map.put("overlay", overlay); //미리 만들어 둔 hashmap map 에 오버레이라는 키로 오버레이 변수의 값을 담아줌
		
		return map; //map 을 컨트롤러에게 반환
	}

	public HashMap<String, Object> join(HashMap<String, String> params) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int row = dao.join(params);
		map.put("success", row);
		return map;
	}

	public int login(String id, String pw) {
		return dao.login(id,pw);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
