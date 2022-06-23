package com.spring.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;

@Service
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO memberDAO;
	
	//properties 에 있는 내용 불러오기
	@Value("#{config['admin.super_id']}") String adminId;
	@Value("#{config['admin.super_pw']}") String adminPw;
	

	public String login(String id, String pw) {
		
		logger.info("admin ID : {}",adminId);
		logger.info("admin PW : {}",adminPw);
		
		String loginId="";
		
		//받아온 아이디와 비밀번호가 어드민 아이디면 DB 에서 값을 가져오지 않는다
		if (id.equals(adminId) && pw.equals(adminPw)) {
			loginId=id;
		}else {
			loginId = memberDAO.login(id,pw);			
		}
		
		return loginId;
	}

}
