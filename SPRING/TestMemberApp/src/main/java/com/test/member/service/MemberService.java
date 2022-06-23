package com.test.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.member.dao.MemberDAO;
import com.test.member.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired MemberDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int join(HashMap<String, String> params) {
		String id = params.get("id");
		String pw = params.get("pw");
		String name = params.get("name");
		String age = params.get("age");
		String gender = params.get("gender");
		String email = params.get("email");
		
		logger.info(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
		
		int result = dao.join(id,pw,name,age,gender,email);
		logger.info("회원가입 결과 : "+result);
		
		return result;
	}

	public String login(String id, String pw) {
		logger.info("로그인 요청 : "+id+"/"+pw );
		String loginId = dao.login(id, pw);
		return loginId;
	}

	public ArrayList<MemberDTO> list() {
		ArrayList<MemberDTO> list = dao.list();
		return list;
	}

	public int del(String id) {
		return dao.del(id);
	}

	public MemberDTO detail(String id) {
		return dao.detail(id);
	}

	public int update(HashMap<String, String> params) {
		String id = params.get("id");
		String pw = params.get("pw");
		String name = params.get("name");
		String age = params.get("age");
		String gender = params.get("gender");
		String email = params.get("email");
		
		logger.info(id+"/"+pw+"/"+name+"/"+age+"/"+gender+"/"+email);
		
		return dao.update(id,pw,name,age,gender,email);
	}

}
