package com.ajax.member.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajax.member.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public HashMap<String, Object> overlay(String id) {
		int result = dao.overlay(id);
		logger.info("id 중복확인 결과 : "+result);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

	public HashMap<String, Object> regist(HashMap<String, String> params) {
		
		logger.info("회원가입 요청 : {}",params.get("id"));
		int result= dao.regist(params);
		logger.info("회원가입 등록 결과 : "+result);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	public int login(String id, String pw) {
		return dao.login(id,pw);
	}

}
