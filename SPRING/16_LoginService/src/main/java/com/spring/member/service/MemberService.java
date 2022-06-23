package com.spring.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.dao.MemberDAO;

@Service
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO dao;

	public String login(String id, String pw) {
		logger.info("로그인 요청 Service 도착");
		return dao.login(id,pw);
	}


	
	
	
	
	
	
	

}
