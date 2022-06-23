package kr.co.gudee.member.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudee.member.dao.MemberDAO;

@Service
public class MemberService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MemberDAO memberDAO;

	public String login(String id, String pw) {
		logger.info("{}/{} 로그인 Member Service 도착",id,pw);
		return memberDAO.login(id,pw);
	}
	
	
	
	
	

}
